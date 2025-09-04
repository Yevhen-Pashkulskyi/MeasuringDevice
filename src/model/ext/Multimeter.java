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

    public void realVoltage(double voltage) {
        if(isConditionOnOff() && isConditionWorking()){
            if (voltage < MIN_VOLTAGE - MEASUREMENT_ERROR_VOLTAGE || voltage > MAX_VOLTAGE +  MEASUREMENT_ERROR_VOLTAGE) {
                System.out.printf("Значення %f за межами діапазону %f - %f", voltage,
                        MIN_VOLTAGE - MEASUREMENT_ERROR_VOLTAGE, MAX_VOLTAGE + MEASUREMENT_ERROR_VOLTAGE);
            }else {
                System.out.println("\nVoltage: " + voltage + "\n");
            }
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Класс мультіметр");
    }
}
