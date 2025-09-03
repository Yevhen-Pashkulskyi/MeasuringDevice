import model.Device;

public class App {
    public static void main(String[] args) {
        Device gauge = new Device();
        gauge.setName("Soldering Iron");
        gauge.setHeight(3.0);
        gauge.setLength(12.0);
        gauge.setWidth(3.0);
        gauge.setWeight(150.0);
        gauge.setVoltage(12.0);
        gauge.setCurrent(5.0);
        gauge.setFrequency(50.0);
        gauge.setConditionOnOff(true);
        if (gauge.isConditionOnOff()) {
            gauge.setConditionWorking(true);
        }
        System.out.printf("\nНазва = %s; Висота = %.2f; Довжина = %.2f; Ширина = %.2f; Вага = %.2f; Напруга = %.2f Вольт;" +
                        "Струм = %.2f А; Частота = %.2f Гц; Ввімкнений = %b; Працює = %b\n",
                gauge.getName(), gauge.getHeight(), gauge.getLength(), gauge.getWidth(), gauge.getWeight(),
                gauge.getWidth(), gauge.getVoltage(), gauge.getCurrent(),
                gauge.getFrequency(), gauge.isConditionOnOff(), gauge.isConditionWorking());

        System.out.println();

        Device thermometer = new Device("Hairdryer", 7.0, 25.0, 10.0, 450.0,
                220, 5.91, 50, false, false);
        System.out.println(thermometer.toString());
    }
}
