import sapienza.iot.Interfaces.ReadDoubleSensor;
import sapienza.iot.Interfaces.ReadFloatSensor;
import sapienza.iot.Interfaces.ReadIntSensor;
import sapienza.iot.Interfaces.ReadLocationSensor;

public class ReadSensorImpl implements ReadDoubleSensor, ReadFloatSensor, ReadIntSensor, ReadLocationSensor {
    @Override
    public Long getLongitude() {
        return new Long(12492373);
    }

    @Override
    public Long getLatitude() {
        return new Long(41890251);
    }

    @Override
    public Integer getInt() {
        return new Integer(9);
    }

    @Override
    public Float getFloat() {
        return new Float(10.5);
    }

    @Override
    public Double getDouble() {
        return new Double(10.8491028);
    }
}
