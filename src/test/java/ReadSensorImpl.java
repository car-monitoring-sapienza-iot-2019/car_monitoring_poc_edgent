import sapienza.iot.Interfaces.ReadDoubleSensor;
import sapienza.iot.Interfaces.ReadFloatSensor;
import sapienza.iot.Interfaces.ReadIntSensor;
import sapienza.iot.Interfaces.ReadLocationSensor;

public class ReadSensorImpl implements ReadDoubleSensor, ReadFloatSensor, ReadIntSensor, ReadLocationSensor {
    @Override
    public Double getLongitude() {
        return 12492373d;
    }

    @Override
    public Double getLatitude() {
        return 41890251d;
    }

    @Override
    public Integer getInt() {
        return 9;
    }

    @Override
    public Float getFloat() {
        return 10.5f;
    }

    @Override
    public Double getDouble() {
        return 10.8491028;
    }
}
