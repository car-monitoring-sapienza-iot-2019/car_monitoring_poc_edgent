package sapienza.iot;

import com.google.gson.JsonObject;
import org.apache.edgent.function.Supplier;
import sapienza.iot.Interfaces.ReadDoubleSensor;
import sapienza.iot.Interfaces.ReadFloatSensor;
import sapienza.iot.Interfaces.ReadIntSensor;
import sapienza.iot.Interfaces.ReadLocationSensor;

import java.time.LocalDateTime;


public class DataAggregator implements Supplier<JsonObject> {

    private ReadFloatSensor throttleSensor;
    private ReadIntSensor rpmSensor;
    private ReadLocationSensor locationSensor;
    private ReadDoubleSensor massAirFlowSensor;
    private ReadIntSensor speedSensor;
    private ReadFloatSensor engineTemperatureSensor;

    // Constructor
    public DataAggregator(DataBuilder builder) {
        this.throttleSensor = builder.getThrottleSensor();
        this.rpmSensor = builder.getEngineRPMSensor();
        this.locationSensor = builder.getLocationSensor();
        this.massAirFlowSensor = builder.getMassAirFlowSensor();
        this.speedSensor = builder.getSpeedSensor();
        this.engineTemperatureSensor = builder.getTemperatureSensor();


    }


    @Override
    public JsonObject get() {
        Double lat = this.locationSensor.getLatitude();
        Double lon = this.locationSensor.getLongitude();
        Float throttle = this.throttleSensor.getFloat();
        Integer rpm = this.rpmSensor.getInt();
        Double massAirFlow = this.massAirFlowSensor.getDouble();
        Integer speed = this.speedSensor.getInt();
        Float engineTemperature = this.engineTemperatureSensor.getFloat();
        String date = LocalDateTime.now().toString();


        JsonObject obj = new JsonObject();
        obj.addProperty("date", date);
        if (lat == null || lon == null) {
            obj.add("location", null);
        } else {
            JsonObject coords = new JsonObject();
            coords.addProperty("lat", lat);
            coords.addProperty("lon", lon);
            obj.add("location", coords);
        }
        if (throttle == null)
            obj.add("throttle", null);
        else
            obj.addProperty("throttle", throttle);
        if (rpm == null)
            obj.add("rpm", null);
        else
            obj.addProperty("rpm", rpm);
        if (massAirFlow == null)
            obj.add("massAirFlow", null);
        else
            obj.addProperty("massAirFlow", massAirFlow);
        if (speed == null)
            obj.add("speed", null);
        else
            obj.addProperty("speed", speed);
        if (engineTemperature == null)
            obj.add("engineTemperature", null);
        else
            obj.addProperty("engineTemperature", engineTemperature);

        return obj;
    }
}
