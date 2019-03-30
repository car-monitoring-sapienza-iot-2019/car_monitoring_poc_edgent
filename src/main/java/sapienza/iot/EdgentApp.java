package sapienza.iot;

import com.google.gson.JsonObject;
import org.apache.edgent.connectors.iot.IotDevice;
import org.apache.edgent.connectors.iot.QoS;
import org.apache.edgent.connectors.iotp.IotpDevice;
import org.apache.edgent.providers.direct.DirectProvider;
import org.apache.edgent.providers.direct.DirectTopology;
import org.apache.edgent.topology.TStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class EdgentApp {

    public static void init(Properties prop, DataBuilder builder) {
        DirectProvider dp = new DirectProvider();
        DirectTopology topology = dp.newTopology();
        IotDevice device = new IotpDevice(topology, prop);
        DataAggregator sensors = new DataAggregator(builder);
        TStream<JsonObject> jsonStream = device.topology().poll(sensors, 1, TimeUnit.SECONDS);
        jsonStream.print();
        dp.submit(topology);
        device.events(jsonStream, "0001", QoS.FIRE_AND_FORGET);
    }

}
