package sapienza.iot;

import sapienza.iot.Interfaces.ReadDoubleSensor;
import sapienza.iot.Interfaces.ReadFloatSensor;
import sapienza.iot.Interfaces.ReadIntSensor;
import sapienza.iot.Interfaces.ReadLocationSensor;

public class DataBuilder {
    private ReadFloatSensor throttleSensor;
    private ReadIntSensor rpmSensor;
    private ReadLocationSensor locationSensor;
    private ReadDoubleSensor massAirFlowSensor;
    private ReadIntSensor speedSensor;
    private ReadFloatSensor engineTemperatureSensor;

    public DataBuilder() {

    }

    public void setThrottleSensor(ReadFloatSensor sensor) {
        this.throttleSensor = sensor;
    }

    public void setEngineRPMSensor(ReadIntSensor sensor) {
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

    public void setTemperatureSensor(ReadFloatSensor sensor) {
        this.engineTemperatureSensor = sensor;
    }


    public ReadFloatSensor getThrottleSensor() {
        return this.throttleSensor;
    }

    public ReadIntSensor getEngineRPMSensor() {
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

    public ReadFloatSensor getTemperatureSensor() {
        return this.engineTemperatureSensor;
    }

    public DataAggregator build() {
        return new DataAggregator(this);
    }
}