import model.ext.ElectricMeasuringDevice;
import model.ext.Multimeter;
import model.utill.Utility;
import view.View;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        View view = new View();

        Multimeter multimeter = new Multimeter("Brymen EVM-839", 30.0, 168.0, 70.0, 350.0,
                24, 65, 50);
        String choice = "";
        boolean flag = true;
        while (flag) {
            view.showMenu();
            System.out.print("Input choice: ");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    if (!ElectricMeasuringDevice.isConditionOnOff()) {
                        System.out.println("\nПрилад не ввімкнутий\n");
                    } else {
                        multimeter.realVoltage(Utility.randomDouble());
                    }
                    break;
                case "2":
                    ElectricMeasuringDevice.setConditionOnOff(true);
                    ElectricMeasuringDevice.setConditionWorking(true);
                    System.out.println("\nПрилад готов працювати\n");
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("\nНе вірний ввод спробуйте ще!\n");
            }
        }
    }
}
