package interdroid.swan.swansong;

import android.os.Bundle;
import android.util.Log;

public class SensorValueExpression implements ValueExpression {

	private String mLocation;
	private String mEntity;
	private String mValuePath;
	private Bundle mConfig;
	private HistoryReductionMode mMode;
	private long mHistoryLength;
	private Bundle mHttpConfig;


	public SensorValueExpression(String location, String entity,
			String valuePath, Bundle config, HistoryReductionMode mode,
			long historyLength, Bundle httpConfig) {
		mLocation = location;
		mEntity = entity;
		mValuePath = valuePath;
		mConfig = config;
		if (mConfig == null) {
			mConfig = new Bundle();
		}
		mMode = mode;
		mHistoryLength = historyLength;
		mHttpConfig = httpConfig;
		if (mHttpConfig == null) {
			Log.e("Roshan","Wierd: SensorValueExpression mHttpConfig is null");
			mHttpConfig = new Bundle();
		}

		Log.e("Roshan","SensorValueExpression constructor called");

	}

	@Override
	public HistoryReductionMode getHistoryReductionMode() {
		return mMode;
	}

	public long getHistoryLength() {
		return mHistoryLength;
	}

	@Override
	public String toParseString() {
		String result = mLocation + "@" + mEntity + ":" + mValuePath;
		if (mConfig != null && mConfig.size() > 0) {
			boolean first = true;
			for (String key : mConfig.keySet()) {
				String value = "" + mConfig.get(key);
				if (mConfig.get(key) instanceof String) {
					value = "'" + value + "'";
				}
				result += (first ? "?" : "#") + key + "=" + value;
				first = false;
			}
		}
		if (mHttpConfig != null && mHttpConfig.size() > 0) {
			boolean first = true;
			for (String key : mHttpConfig.keySet()) {
				String value = "" + mHttpConfig.get(key);
				//if (mHttpConfig.get(key) instanceof String) {
				//	value = "'" + value + "'";
				//}
				Log.e("Roshan-SVExpression", "key "+key +" value " +value);
				result += (first ? "$" : "~") + key + "=" + value;
				first = false;
			}
		}
		result += "{" + mMode.toParseString() + "," + mHistoryLength + "}";
		Log.e("Roshan-SVExpression", result);
		return result;
	}

	public String getEntity() {
		return mEntity;
	}

	@Override
	public void setInferredLocation(String location) {
		throw new RuntimeException(
				"Please don't use this method. For internal use only.");
	}

	public String getValuePath() {
		return mValuePath;
	}

	public String getLocation() {
		return mLocation;
	}

	public Bundle getConfiguration() {
		return mConfig;
	}

	public Bundle getHttConfiguration(){

		return mHttpConfig;
	}


}
