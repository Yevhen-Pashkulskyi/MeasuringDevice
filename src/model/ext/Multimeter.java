package model.ext;

public class Multimeter extends ElectricMeasuringDevice {
    private final double MEASUREMENT_ERROR_VOLTAGE = 0.01;
    private final double MIN_VOLTAGE = 110.0;
    private final double MAX_VOLTAGE = 280.0;

    private String nameMeasurement;

    public Multimeter(String name, double height, double length, double width, double weight, double voltage, double current, double frequency) {
        super(height, length, width, weight, voltage, current, frequency);
        this.name = name;

    }

    public void realVoltage(double voltage) {
        if (isConditionOnOff() && isConditionWorking()) {
            if (voltage < MIN_VOLTAGE - MEASUREMENT_ERROR_VOLTAGE || voltage > MAX_VOLTAGE + MEASUREMENT_ERROR_VOLTAGE) {
                System.out.printf("\nЗначення %.2f за межами діапазону %.2f - %.2f\n\n", voltage,
                        MIN_VOLTAGE - MEASUREMENT_ERROR_VOLTAGE, MAX_VOLTAGE + MEASUREMENT_ERROR_VOLTAGE);
            } else {
                System.out.printf("\nVoltage: %.2f\n\n", voltage);
            }
        }
    }

    public void setNameMeasurement(String nameMeasurement) {
        this.nameMeasurement = nameMeasurement;
    }

    public String getNameMeasurement() {
        return nameMeasurement;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Класс мультіметр");
    }
}
