import Interfaces.ReadDoubleSensor;
import Interfaces.ReadFloatSensor;
import Interfaces.ReadIntSensor;
import Interfaces.ReadLocationSensor;

public class DataSender {

    private final String ADDRESS = "";
    private final String KEY = "";

    public void sendThrottle(ReadIntSensor sensor) {
        int value = sensor.getInt();
        //TODO
    }

    public void sendRPM(ReadFloatSensor sensor) {
        float value = sensor.getFloat();
        //TODO
    }

    public void sendLocation(ReadLocationSensor sensor) {
        long latitude = sensor.getLatitude();
        long longitude = sensor.getLongitude();
        //TODO
    }

    public void sendMassAirFlow(ReadDoubleSensor sensor) {
        double value = sensor.getDouble();
        //TODO
    }

    public void sendSpeed(ReadIntSensor sensor) {
        int value = sensor.getInt();
        //TODO
    }

    public void sendEngineTemperature(ReadIntSensor sensor) {
        int value = sensor.getInt();
        //TODO
    }
}
