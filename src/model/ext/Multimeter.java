package model.ext;

public class Multimeter extends ElectricMeasuringDevice {
    private final double MEASUREMENT_ERROR_VOLTAGE = 0.01;
    private final double MIN_VOLTAGE = 80.0;
    private final double MAX_VOLTAGE = 280.0;

    private String voltageMeasurement;

    public Multimeter(String name, double height, double length, double width, double weight, double voltage, double current, double frequency, boolean conditionWorking) {
        super(height, length, width, weight, voltage, current, frequency, conditionWorking);
        this.name = name;

    }

    public void realVoltage(){

    }

    @Override
    public void showInfo() {
        super.showInfo();
    }
}
