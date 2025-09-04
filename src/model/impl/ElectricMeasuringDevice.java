package model.impl;

import model.Device;

public class ElectricMeasuringDevice implements Device {
    static boolean conditionOnOff; // стан (on, off)
    static boolean conditionWorking;

    private String nameDevice;
    private String serialNumber;

    private double height; // висота
    private double length; // довжина
    private double width; // ширина
    private double weight; // вага в граммах
    private double voltage; // напруга
    private double current; // струм
    private double frequency; // частота


    public ElectricMeasuringDevice(String nameDevice,double height, double length, double width, double weight,
                                   double voltage, double current, double frequency) {
        this.nameDevice = nameDevice;
        this.height = height;
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.voltage = voltage;
        this.current = current;
        this.frequency = frequency;
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
    public String getNameDevice() {
        return nameDevice;
    }

    @Override
    public void setNameDevice(String name) {
        if(name == null || name.isEmpty()) {
            this.nameDevice = "Unknown";
        }
        this.nameDevice = name;
    }

    @Override
    public void showInfo() {
        System.out.printf("Name company = %s\n" +
                        "Height = %.2f mm\n" +
                        "Length = %.2f mm\n" +
                        "Width = %.2f mm\n" +
                        "Weight = %.2f gr\n" +
                        "Voltage = %.2f V\n" +
                        "Current = %.2f W\n" +
                        "Frequency = %.2f Hz\n" +
                        "Condition Working = %b\n",
                NAME_COMPANY, this.height, this.length, this.width, this.weight,
                this.voltage, this.current, this.frequency, this.conditionWorking);
    }
}
