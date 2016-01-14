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

import org.json.JSONException;
import org.json.JSONObject;

public class MovementSensor extends AbstractSwanSensor {
	public static final String TAG = "MovementSensor";
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
			return R.xml.movement_preferences;
		}

	}

	/** Value of ACCURACY must be one of SensorManager.SENSOR_DELAY_* */
	public static final String ACCURACY = "accuracy";

	public static final String X_FIELD = "x";
	public static final String Y_FIELD = "y";
	public static final String Z_FIELD = "z";
	public static final String TOTAL_FIELD = "total";

	public String STORAGE = "FALSE";

	public  static String MY_SERVER_ADDRESS = "https://api.thingspeak.com/update.json";

	private Sensor accelerometer;
	private SensorManager sensorManager;
	private SensorEventListener sensorEventListener = new SensorEventListener() {

		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				currentConfiguration.putInt(ACCURACY, accuracy);
			}
		}

		public void onSensorChanged(SensorEvent event) {
			long now = System.currentTimeMillis();
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				for (int i = 0; i < 3; i++) {
					putValueTrimSize(VALUE_PATHS[i], null, now,
							(double) event.values[i]);
				}
				double len2 = (double) Math.sqrt(event.values[0]
						* event.values[0] + event.values[1] * event.values[1]
						+ event.values[2] * event.values[2]);

				putValueTrimSize(TOTAL_FIELD, null, now, len2);

				if(STORAGE.contains("TRUE")){

					JSONObject content = new JSONObject();
					try {
						content.put("api_key","VA1FPOVBRSVBF8LV");
						content.put("field1",event.values[0]);
					} catch (JSONException e) {
						e.printStackTrace();
					}

					//ServerConnection serverConnection = new ServerConnection(MY_SERVER_ADDRESS);
					//serverConnection.postMethod(content.toString());


				}

			}
		}
	};

	@Override
	public String[] getValuePaths() {
		return new String[] { X_FIELD, Y_FIELD, Z_FIELD, TOTAL_FIELD };
	}

	@Override
	public void initDefaultConfiguration(Bundle DEFAULT_CONFIGURATION) {
		DEFAULT_CONFIGURATION.putInt(ACCURACY,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onConnected() {
		SENSOR_NAME = "Movement Sensor";
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> sensorList = sensorManager
				.getSensorList(Sensor.TYPE_ACCELEROMETER);
		if (sensorList.size() > 0) {
			accelerometer = sensorList.get(0);
		} else {
			Log.e(TAG, "No accelerometer found on device!");
		}
	}

	@Override
	public final void register(String id, String valuePath, Bundle configuration, final Bundle httpConfiguration) {
		super.register(id,valuePath,configuration,httpConfiguration);
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
					// accuracy can be string or int
					if (configuration.getString(ACCURACY, null) == null) {
						highestAccuracy = Math.min(highestAccuracy,
								configuration.getInt(ACCURACY));
					} else {
						highestAccuracy = Math.min(highestAccuracy, Integer
								.parseInt(configuration.getString(ACCURACY)));
					}

				}
			}
			highestAccuracy = Math.max(highestAccuracy,
					SensorManager.SENSOR_DELAY_FASTEST);
			sensorManager.registerListener(sensorEventListener, accelerometer,
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
		return accelerometer.getPower();
	}
}
