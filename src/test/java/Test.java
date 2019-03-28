import com.google.gson.JsonObject;

import Interfaces.ReadDoubleSensor;
import Interfaces.ReadFloatSensor;
import Interfaces.ReadIntSensor;
import Interfaces.ReadLocationSensor;

public class Test {
    public static void main(String[] args){
        

        ReadSensorImpl sensor = new ReadSensorImpl();
        DataBuilder builder = new DataBuilder();
        builder.setEngineRPMSensor(sensor);
        builder.setLocationSensor(sensor);
        builder.setMassAirFlowSensor(sensor);
        builder.setSpeedSensor(sensor);
        builder.setTemperatureSensor(sensor);
        builder.setThrottleSensor(sensor);

        DataAggregator aggregator = new DataAggregator(builder);


        JsonObject obj = aggregator.getData();
        System.out.println(obj);
    }
}