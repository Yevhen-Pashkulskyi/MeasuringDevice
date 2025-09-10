package model;

public class Device {
    private String name; // назва

    private double height; // висота
    private double length; // довжина
    private double width; // ширина
    private double weight; // вага в граммах
    private double voltage; // напруга
    private double current; // струм
    private double frequency; // частота

    // стан
    private boolean conditionOnOff; // on, off
    private boolean conditionWorking; // працює, не працює

    public Device() {
    }

    public Device(String name, double height, double length, double width, double weight,
                  double voltage, double current, double frequency, boolean conditionOnOff, boolean conditionWorking) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
        this.weight = weight;
        this.voltage = voltage;
        this.current = current;
        this.frequency = frequency;
        this.conditionOnOff = conditionOnOff;
        this.conditionWorking = conditionWorking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public void setCurrent(double current) {
        this.current = current;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return String.format("Назва %s\n" +
                        "Висота %.2f\n" +
                        "Довжина %.2f\n" +
                        "Ширина %.2f\n" +
                        "Вага %.2f\n" +
                        "Напруга %.2f Вольт\n" +
                        "Струм %.2f А\n" +
                        "Частота %.2f Гц\n",this.name, this.height, this.length, this.width, this.weight,
                this.voltage, this.current, this.frequency);
    }

}
