package model.ext;

import model.Device;

public class ElectricMeasuringDevice extends Device {
    static boolean conditionOnOff; // стан (on, off)
    static boolean conditionWorking;

    private double height; // висота
    private double length; // довжина
    private double width; // ширина
    private double weight; // вага в граммах
    private double voltage; // напруга
    private double current; // струм
    private double frequency; // частота

    public ElectricMeasuringDevice(double height, double length, double width, double weight,
                                   double voltage, double current, double frequency) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.voltage = voltage;
        this.current = current;
        this.frequency = frequency;
//        this.conditionWorking = conditionWorking;
    }

    public static boolean isConditionOnOff() {
        return conditionOnOff;
    }

    public static void setConditionOnOff(boolean conditionOnOff) {
        ElectricMeasuringDevice.conditionOnOff = conditionOnOff;
    }

    public static boolean isConditionWorking() {
        return conditionWorking;
    }

    public static void setConditionWorking(boolean conditionWorking) {
        ElectricMeasuringDevice.conditionWorking = conditionWorking;
    }

    @Override
    public void showInfo() {
        System.out.printf("Name = %s\n" +
                        "Height = %.2f mm\n" +
                        "Length = %.2f mm\n" +
                        "Width = %.2f mm\n" +
                        "Weight = %.2f gr\n" +
                        "Voltage = %.2f V\n" +
                        "Current = %.2f W\n" +
                        "Frequency = %.2f Hz\n" +
                        "Condition Working = %b\n",
                this.name, this.height, this.length, this.width, this.weight,
                this.voltage, this.current, this.frequency, this.conditionWorking);
    }
}
