package control;

import model.impl.ElectricMeasuringDevice;
import model.impl.MultimeterMS8233C;
import utill.Rounder;
import view.View;

import java.util.Scanner;

public class ControlMultimeter {
    private Scanner scan = new Scanner(System.in);

    public void run() {
        View view = new View();
        MultimeterMS8233C multimeterMS8233C = new MultimeterMS8233C(50.0, 150.0, 70.0,
                150.0, 9.0, 0.25, 50);
        multimeterMS8233C.setNameDevice("MS8233C");
        do {
            view.showMenu();
            String ch = scan.nextLine();
            if (ch.equals("0") || ch.equalsIgnoreCase("exit")
                    || ch.equalsIgnoreCase("quit")) {
                break;
            }
            switch (ch) {
                case "1":
                    ElectricMeasuringDevice.setConditionOnOff(true);
                    ElectricMeasuringDevice.setConditionWorking(true);
                    System.out.printf("\nПрилад %s готов вимірювати.\n\n", multimeterMS8233C.getNameDevice());
                    break;
                case "2":
                    boolean flagControl = true;
                    while (flagControl) {
                        view.listOfMeasurements();
                        ch = scan.nextLine();
                        switch (ch) {
                            case "1":
                                int resVoltage = (int) multimeterMS8233C.countVoltage(Rounder.randomDouble(0, 700));
                                result(resVoltage, multimeterMS8233C.getNameDevice());
                                break;
                            case "2":
                                result((multimeterMS8233C.countResistance(Rounder.randomDouble(0, 2_500_000))),
                                        multimeterMS8233C.getNameDevice());
                                break;
                            case "0":
                                flagControl = false;
                                break;
                            default:
                                System.out.println("\nНевірний вибір спробуй ще\n");
                                break;
                        }
                    }
                    break;

                case "3":
                    ElectricMeasuringDevice.setConditionOnOff(false);
                    System.out.printf("\nПрилад %s вимкнений.\n\n", multimeterMS8233C.getNameDevice());
                    break;

                default:
                    System.out.println("\nНевірний ввід спробуй ще!\n");
                    break;
            }
        } while (true);
    }

    private void result(int voltage, String nameDevice) {
        if (voltage == -1) {
            System.out.println("\nДля розрахунків увімкніть прилад" + nameDevice + "\n");
        } else {
            System.out.println("\nВольтаж = " + voltage + " Вольт\n");
        }
    }

    private void result(double resistance, String nameDevice) {
        int kOm = 1000;
        int mOm = 1000_000;
        if (resistance == -1) {
            System.out.printf("\nДля розрахунків увімкніть прилад %s\n\n" , nameDevice);
        } else if (resistance > MultimeterMS8233C.RESISTANCE_MAX) {
            System.out.println("ЗА МЕЖАМИ РОЗРАХУНКУ");
        } else if (resistance > mOm) {
            System.out.printf("\nСпротив = %.3f мОм\n\n", resistance / mOm);
        } else if (resistance >= kOm && resistance < mOm) {
            System.out.printf("\nСпротив = %.3f кОм\n\n", resistance / kOm);
        } else {
            System.out.printf("\nСпротив = %.3f Ом\n\n", resistance);
        }
    }
}
