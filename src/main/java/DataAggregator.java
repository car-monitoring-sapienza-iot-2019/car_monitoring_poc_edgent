import java.time.LocalDateTime;
import org.apache.edgent.function.Supplier;

import com.google.gson.JsonObject;

import Interfaces.ReadDoubleSensor;
import Interfaces.ReadFloatSensor;
import Interfaces.ReadIntSensor;
import Interfaces.ReadLocationSensor;



public class DataAggregator implements Supplier<JsonObject> {

    private ReadIntSensor throttleSensor;
    private ReadFloatSensor rpmSensor;
    private ReadLocationSensor locationSensor;
    private ReadDoubleSensor massAirFlowSensor;
    private ReadIntSensor speedSensor;
    private ReadIntSensor engineTemperatureSensor;

    // Constructor
    public DataAggregator(DataBuilder builder){
        this.throttleSensor = builder.getThrottleSensor();
        this.rpmSensor = builder.getEngineRPMSensor();
        this.locationSensor = builder.getLocationSensor();
        this.massAirFlowSensor = builder.getMassAirFlowSensor();
        this.speedSensor = builder.getSpeedSensor();
        this.engineTemperatureSensor = builder.getTemperatureSensor();
        

    }


    @Override
    public JsonObject get() {
        Long lat = this.locationSensor.getLatitude();
        Long lon = this.locationSensor.getLongitude();
        Integer throttle = this.throttleSensor.getInt();
        Float rpm = this.rpmSensor.getFloat();
        Double massAirFlow = this.massAirFlowSensor.getDouble();
        Integer speed = this.speedSensor.getInt();
        Integer engineTemperature = this.engineTemperatureSensor.getInt();
        String date = LocalDateTime.now().toString();


        JsonObject obj = new JsonObject();
        obj.addProperty("date", date);
        if (lat == null || lon == null) {
            obj.add("location", null);
        }
        else {
            JsonObject coords = new JsonObject();
            coords.addProperty("lat", lat);
            coords.addProperty("lon", lon);
            obj.add("location", coords);
        }
        if (throttle == null)
            obj.add("throttle", null);
        else
            obj.addProperty("throttle", throttle);
        if(rpm ==null)
            obj.add("rpm",null);
        else
            obj.addProperty("rpm", rpm);
        if(massAirFlow == null)
            obj.add("massAirFlow",null);
        else
            obj.addProperty("massAirFlow", massAirFlow);
        if(speed==null)
            obj.add("speed", null);
        else
            obj.addProperty("speed", speed);
        if(engineTemperature==null)
            obj.add("engineTemperature", null);
        else
            obj.addProperty("engineTemperature", engineTemperature);

        return obj;
    }
}
