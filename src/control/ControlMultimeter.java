package control;

import model.impl.ElectricMeasuringDevice;
import model.impl.MultimeterMS8233C;
import view.View;

import java.util.Scanner;

public class ControlMultimeter {
    private Scanner scan = new Scanner(System.in);

    public void run() {
        View view = new View();
        MultimeterMS8233C multimeterMS8233C = new MultimeterMS8233C("MS8233C", 50.0, 150.0, 70.0,
                150.0, 9.0, 0.25, 50);
        boolean flagMainMenu = true;
        do {
            String ch = scan.nextLine();
            if (ch.equals("0") || ch.equalsIgnoreCase("exit")
                    || ch.equalsIgnoreCase("quit")) {
                flagMainMenu = false;
            }
            switch (ch) {
                case "1":
                    ElectricMeasuringDevice.setConditionOnOff(true);
                    ElectricMeasuringDevice.setConditionWorking(true);
                    System.out.println("Прилад готов вимірювати.");
                    break;
                case "2":
                    boolean flagControl = true;
                        while (flagControl) {
                            view.listOfMeasurements();
                            ch = scan.nextLine();

                        }

                    break;
                case "3":
                    ElectricMeasuringDevice.setConditionOnOff(false);
                    System.out.println("Прилад вимкнений.");
                    break;
                default:
                    System.out.println("Невірний ввід спробуй ще!");
                    break;
            }

        } while (flagMainMenu);
    }

    private void result(int voltage) {

    }

    private void result(double resistance) {

    }
}
