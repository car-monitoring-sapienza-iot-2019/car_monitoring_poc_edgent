import org.junit.Test;
import sapienza.iot.DataBuilder;
import sapienza.iot.EdgentApp;
import java.util.Properties;

import static org.junit.Assert.*;

public class DataSenderTest {

    @Test
    public void sendThrottle() {
    }

    @Test
    public void sendTemperature() {
    }

    @Test
    public void sendLocation() {
    }

    @Test
    public void sendMassAirFlow() {
    }

    @Test //Fill properties fields with specific device info
    public void InitEdgentApp() {
        ReadSensorImpl sensor = new ReadSensorImpl();
        DataBuilder builder = new DataBuilder();
        builder.setEngineRPMSensor(sensor);
        builder.setLocationSensor(sensor);
        builder.setMassAirFlowSensor(sensor);
        builder.setSpeedSensor(sensor);
        builder.setTemperatureSensor(sensor);
        builder.setThrottleSensor(sensor);

        Properties prop = new Properties();

        prop.setProperty("org", "");
        prop.setProperty("type", "");
        prop.setProperty("id", "");
        prop.setProperty("auth-method", "token");
        prop.setProperty("auth-token", "");

        EdgentApp.init(prop, builder);

        while(true){}

    }
}