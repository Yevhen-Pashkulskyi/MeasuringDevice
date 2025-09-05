import model.ext.ElectricMeasuringDevice;
import model.ext.Multimeter;
import utill.RandomNumber;
import view.View;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Multimeter multimeter = new Multimeter("Bremen EVM-839", 30.0, 168.0, 70.0, 350.0,
                24, 65, 50);
        String choice;
        boolean flag = true;

        while (flag) {
            View view = new View();
            view.showMenu();
            boolean onOff;

            choice = input.nextLine();
            switch (choice) {
                case "1":
                    if (!ElectricMeasuringDevice.isConditionOnOff()) {
                        System.out.println("\nПрилад не ввімкнутий\n");
                    } else {
                        view.listOfMeasurements();

                        switch (input.nextLine()) {
                            case "1":
                                multimeter.setNameMeasurement("voltage measurement");
                                if (multimeter.getNameMeasurement().equals("voltage measurement")) {
                                    multimeter.realVoltage(RandomNumber.randomDouble());
                                }
                                break;
                            case "0":
                                break;
                        }
                    }
                    break;
                case "2":
                    ElectricMeasuringDevice.setConditionOnOff(true);
                    ElectricMeasuringDevice.setConditionWorking(true);
                    System.out.println("\nПрилад готов працювати\n");
                    break;
                case "0":
                    onOff = ElectricMeasuringDevice.isConditionOnOff();
                    ElectricMeasuringDevice.setConditionOnOff(false);
                    if (onOff == true) {
                        System.out.println("Прилад вимикається");
                    } else {
                        System.out.println("Вихід з програми!");
                    }
                    flag = false;
                    break;
                default:
                    System.out.println("\nНе вірний ввод спробуйте ще!\n");
            }
        }
    }
}
