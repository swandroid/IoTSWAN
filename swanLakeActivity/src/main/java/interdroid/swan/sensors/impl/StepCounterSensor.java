package interdroid.swan.sensors.impl;

import java.io.IOException;

import interdroid.swan.R;
import interdroid.swan.sensors.AbstractConfigurationActivity;
import interdroid.swan.sensors.AbstractSwanSensor;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class StepCounterSensor extends AbstractSwanSensor {
	public static final String TAG = "Step Counter Sensor";
	
	/**
	 * The configuration activity for this sensor.
	 * 
	 * 
	 */
	public static class ConfigurationActivity extends AbstractConfigurationActivity {

		@Override
		public final int getPreferencesXML() {
			return R.xml.stepcounter_preferences;
		}
	}

	/** Value of ACCURACY must be one of SensorManager.SENSOR_STATUS_ACCURACY_* */
	public static final String ACCURACY = "accuracy";

	public static final String ACTION_FLUSH_SENSOR = "interdroid.swan.sensors.impl.StepCounterSensor.FlushSensorData";
	
	public static final String STEP_COUNTER = "step_counter";

	private Sensor mStepCounter;
	private SensorManager sensorManager;
	private PendingIntent mSensorUpdatePIntent;
	private SensorEventListener sensorEventListener = new SensorEventListener() {

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
				currentConfiguration.putInt(ACCURACY, accuracy);
			}
		}

		public void onSensorChanged(SensorEvent event) {
			if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
				long now = acceptSensorReading();
				if (now >= 0) {
					Log.d(TAG, "onSensorChanged: " + now + " val " + event.values[0]);
					putValueTrimSize(VALUE_PATHS[0], null, now, event.values[0]);
				}
			}
		}
	};

	@Override
	public String[] getValuePaths() {
		return new String[] { STEP_COUNTER };
	}

	@Override
	public void initDefaultConfiguration(Bundle DEFAULT_CONFIGURATION) {
		DEFAULT_CONFIGURATION.putInt(DELAY, normalizeSensorDelay(SensorManager.SENSOR_DELAY_NORMAL));
		DEFAULT_CONFIGURATION.putInt(ACCURACY, SensorManager.SENSOR_STATUS_ACCURACY_HIGH);
	}

	@Override
	public void onConnected() {
		SENSOR_NAME = "Step Counter Sensor";
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
		if (mStepCounter == null) {
			Toast.makeText(getApplicationContext(), "No step counter found on device", Toast.LENGTH_SHORT).show();
			Log.e(TAG, "No step counter sensor found on device!");		
		}
	}

	/**
	 * Calculates the maximum sensor report interval, based on the
	 * hardware sensor events buffer size, to avoid dropping steps.
	 *
	 * @param stepCounter The Step Counter sensor
	 *
	 * @return Returns the optimal update interval, in milliseconds
	 */
	private static int calcSensorReportInterval(Sensor stepCounter) {
		// We assume that, normally, a person won't do more than
		// two steps in a second (worst case: running)
		final int fifoSize = stepCounter.getFifoReservedEventCount();
		if (fifoSize > 1) {
			return (fifoSize / 2) * 1000;
		}

		// In this case, the device seems not to have an HW-backed
		// sensor events buffer. We're assuming that there's no
		// batching going on, so we don't really need the alarms.
		return 0;
	}
    
	/**
	 * Sets up a wakelock-based alarm that allows this service
	 * to retrieve sensor events before they're dropped out of
	 * the FIFO buffer.
	 */
	private void setupSensorUpdateAlarm(int interval) {
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + interval,
					  interval, mSensorUpdatePIntent);
	}

	@Override
	public final void register(String id, String valuePath, Bundle configuration, final Bundle httpConfiguration) {
		super.register(id, valuePath, configuration, httpConfiguration);
		updateDelay();
	}

	@TargetApi(Build.VERSION_CODES.KITKAT)
	private void updateDelay() {
		sensorManager.unregisterListener(sensorEventListener);
		int delay = getSensorDelay();
		if (delay >= 0) {
			sensorManager.registerListener(sensorEventListener, mStepCounter, delay);
			Log.d(TAG, "delay set to " + delay);

			final int reportInterval = calcSensorReportInterval(mStepCounter);
			if (reportInterval > 0) {
				Log.i(TAG, "Setting up batched data retrieval every " + reportInterval + " ms");
				setupSensorUpdateAlarm(reportInterval);
			} else {
				Log.w(TAG, "This device doesn't support events batching!");
			}		
		}
	}

	@Override
	public final void unregister(String id) {
		updateDelay();
	}

	@Override
	public final void onDestroySensor() {
		sensorManager.unregisterListener(sensorEventListener);
		super.onDestroySensor();
	}

	@Override
	public float getCurrentMilliAmpere() {
		return mStepCounter.getPower();
	}
}
