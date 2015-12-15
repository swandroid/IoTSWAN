package interdroid.swan.sensors;

import interdroid.swan.swansong.TimestampedValue;


interface Sensor {

	void register(in String id, in String valuePath, in Bundle configuration, in Bundle httpConfiguration);

	void unregister(in String id);

	List<TimestampedValue> getValues(in String id, long now, long timespan);

	long getStartUpTime(in String id);
	
	Bundle getInfo();
}

