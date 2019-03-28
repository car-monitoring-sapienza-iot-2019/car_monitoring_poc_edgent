import java.io.File;

import com.google.gson.JsonObject;

import org.apache.edgent.connectors.iot.IotDevice;
import org.apache.edgent.connectors.iot.QoS;
import org.apache.edgent.connectors.iotp.IotpDevice;
import org.apache.edgent.providers.direct.DirectProvider;
import org.apache.edgent.providers.direct.DirectTopology;
import org.apache.edgent.topology.TStream;
import java.util.concurrent.TimeUnit;


public class EdgentApp {
    public static void main(String[] args) {
        DirectProvider dp = new DirectProvider();
        DirectTopology topology = dp.newTopology();

        String deviceCfg = "C:\\Users\\Gabbo\\car_monitoring_poc_edgent\\device.cfg";
        IotDevice device = new IotpDevice(topology, new File(deviceCfg));

        ReadSensorImpl sensor = new ReadSensorImpl();
        DataBuilder builder = new DataBuilder();
        builder.setEngineRPMSensor(sensor);
        builder.setLocationSensor(sensor);
        builder.setMassAirFlowSensor(sensor);
        builder.setSpeedSensor(sensor);
        builder.setTemperatureSensor(sensor);
        builder.setThrottleSensor(sensor);

        DataAggregator sensors = new DataAggregator(builder);

        TStream<JsonObject> jsonStream = device.topology().poll(sensors, 1, TimeUnit.SECONDS);

        jsonStream.print();
        dp.submit(topology);

        device.events(jsonStream, "0001", QoS.FIRE_AND_FORGET);

    }

}
