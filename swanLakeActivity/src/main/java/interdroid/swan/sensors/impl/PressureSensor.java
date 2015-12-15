package interdroid.swan.sensors.impl;

import interdroid.swan.R;
import interdroid.swan.sensors.AbstractConfigurationActivity;
import interdroid.swan.sensors.AbstractSwanSensor;

import java.util.List;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class PressureSensor extends AbstractSwanSensor {
	public static final String TAG = "PressureSensor";
	/**
	 * The configuration activity for this sensor.
	 * 
	 * @author nick &lt;palmer@cs.vu.nl&gt;
	 * 
	 */
	public static class ConfigurationActivity extends
			AbstractConfigurationActivity {

		@Override
		public final int getPreferencesXML() {
			return R.xml.pressure_preferences;
		}

	}

	/** Value of ACCURACY must be one of SensorManager.SENSOR_DELAY_* */
	public static final String ACCURACY = "accuracy";

	public static final String PRESSURE_FIELD = "pressure";

	private Sensor pressureSensor;
	private SensorManager sensorManager;
	private SensorEventListener sensorEventListener = new SensorEventListener() {

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			if (sensor.getType() == Sensor.TYPE_PRESSURE) {
				currentConfiguration.putInt(ACCURACY, accuracy);
			}
		}

		public void onSensorChanged(SensorEvent event) {
			long now = System.currentTimeMillis();
			if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {

				putValueTrimSize(PRESSURE_FIELD, null, now, event.values[0]);
			}
		}
	};

	@Override
	public String[] getValuePaths() {
		return new String[] { PRESSURE_FIELD };
	}

	@Override
	public void initDefaultConfiguration(Bundle DEFAULT_CONFIGURATION) {
		DEFAULT_CONFIGURATION.putInt(ACCURACY,
				SensorManager.SENSOR_DELAY_NORMAL);
	}


	@Override
	public void onConnected() {
		SENSOR_NAME = "Pressure Sensor";
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> sensorList = sensorManager
				.getSensorList(Sensor.TYPE_PRESSURE);
		if (sensorList.size() > 0) {
			pressureSensor = sensorList.get(0);
		} else {
			Toast.makeText(getApplicationContext(),
					"No pressureSensor found on device!", Toast.LENGTH_SHORT)
					.show();
			Log.e(TAG, "No pressureSensor found on device!");
		}
	}

	@Override
	public final void register(String id, String valuePath, Bundle configuration, final Bundle httpConfiguration) {
		updateAccuracy();
	}

	private void updateAccuracy() {
		sensorManager.unregisterListener(sensorEventListener);
		if (registeredConfigurations.size() > 0) {

			int highestAccuracy = mDefaultConfiguration.getInt(ACCURACY);
			for (Bundle configuration : registeredConfigurations.values()) {
				if (configuration == null) {
					continue;
				}
				if (configuration.containsKey(ACCURACY)) {
					highestAccuracy = Math
							.min(highestAccuracy,
									Integer.parseInt(configuration
											.getString(ACCURACY)));
				}
			}
			highestAccuracy = Math.max(highestAccuracy,
					SensorManager.SENSOR_DELAY_FASTEST);
			sensorManager.registerListener(sensorEventListener, pressureSensor,
					highestAccuracy);
		}

	}

	@Override
	public final void unregister(String id) {
		updateAccuracy();
	}

	@Override
	public final void onDestroySensor() {
		sensorManager.unregisterListener(sensorEventListener);
		super.onDestroySensor();
	}
	
	@Override
	public float getCurrentMilliAmpere() {
		return pressureSensor.getPower();
	}
}
