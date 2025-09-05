package model.impl;


public class MultimeterMS8233C extends ElectricMeasuringDevice implements model.Multimeter {
    private final double RESISTANCE_MIN = 0.01;
    private final double RESISTANCE_ERROR = 0.001;
    public static final double RESISTANCE_MAX = 2_000_000.00;


    public MultimeterMS8233C(double height, double length, double width, double weight, double voltage, double current, double frequency) {
        super( height, length, width, weight, voltage, current, frequency);

    }


    @Override
    public double countVoltage(double voltage) {
        if (isConditionOnOff() && isConditionWorking()) {
            if (voltage > MIN_VOLTAGE_ALTERNATING_CURRENT - MEASUREMENT_ERROR_VOLTAGE_ALTERNATING_CURRENT ||
                    voltage < MAX_VOLTAGE_ALTERNATING_CURRENT + MEASUREMENT_ERROR_VOLTAGE_ALTERNATING_CURRENT) {
                return voltage;
            }
        }
        return -1;
    }

    @Override
    public double countResistance(double resistance) {
        if (isConditionOnOff() && isConditionWorking()) {
            if (resistance > RESISTANCE_MIN - RESISTANCE_ERROR || resistance < RESISTANCE_MAX + RESISTANCE_ERROR) {
                return resistance;
            }
        }
        return -1.0;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Класс мультиметр");
    }
}
