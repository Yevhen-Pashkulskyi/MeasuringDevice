package model;

public interface Multimeter {
    int MEASUREMENT_ERROR_VOLTAGE_ALTERNATING_CURRENT = 1;
    int MIN_VOLTAGE_ALTERNATING_CURRENT = 100;
    int MAX_VOLTAGE_ALTERNATING_CURRENT = 600;

    double countVoltage(double voltage);

    double countResistance(double resistance);
}
