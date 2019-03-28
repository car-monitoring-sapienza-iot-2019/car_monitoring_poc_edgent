import Interfaces.*;

public class DataBuilder {
    private ReadIntSensor throttleSensor;
    private ReadFloatSensor rpmSensor;
    private ReadLocationSensor locationSensor;
    private ReadDoubleSensor massAirFlowSensor;
    private ReadIntSensor speedSensor;
    private ReadIntSensor engineTemperatureSensor;
    
    public DataBuilder(){

    }

    public void setThrottleSensor(ReadIntSensor sensor) {
        this.throttleSensor = sensor;
    }
    public void setEngineRPMSensor(ReadFloatSensor sensor) {
        this.rpmSensor = sensor;
    }
    public void setLocationSensor(ReadLocationSensor sensor) {
        this.locationSensor = sensor;
    }
    public void setSpeedSensor(ReadIntSensor sensor) {
        this.speedSensor = sensor;
    }
    public void setMassAirFlowSensor(ReadDoubleSensor sensor) {
        this.massAirFlowSensor = sensor;
    }
    public void setTemperatureSensor(ReadIntSensor sensor) {
        this.engineTemperatureSensor = sensor;
    }


    public ReadIntSensor getThrottleSensor() {
        return this.throttleSensor;
    }
    public ReadFloatSensor getEngineRPMSensor() {
        return this.rpmSensor;
    }
    public ReadLocationSensor getLocationSensor() {
        return this.locationSensor;
    }
    public ReadIntSensor getSpeedSensor() {
        return this.speedSensor;
    }
    public ReadDoubleSensor getMassAirFlowSensor() {
        return this.massAirFlowSensor;
    }
    public ReadIntSensor getTemperatureSensor() {
        return this.engineTemperatureSensor;
    }
    public DataAggregator build(){
        return new DataAggregator(this);
    }
}