package control;

import model.Device;

import java.util.*;

import static javax.swing.JOptionPane.showInputDialog;
import static util.Utility.*;

public class ControlApp {
    public void run() {
        Scanner sc = new Scanner(System.in);
        LinkedList<Device> devices = new LinkedList<>();
        String choice;
        String nameSearch;

        while (true) {
//            System.out.print("input choice: ");
            choice = showInputDialog(null, "Input choice: ");
            if (choice == null || choice.isEmpty()) {
                continue;
            }
            switch (choice) {
                case "1":
//                    System.out.print("Enter the name of the device you want to create: ");
                    devices.addFirst(createDevice(showInputDialog("Enter the name of the device you want to create:")));//sc.nextLine()));
                    System.out.printf("Device with name \"%s\" created\n", devices.getFirst().getName());
                    break;
                case "2":
                    System.out.println("Delete last device: ");
                    System.out.printf("Device with name \"%s\" deleted\n", devices.getLast().getName());
                    devices.removeLast();
                    break;
                case "3":
                    System.out.print("Enter the name of the device to delete: ");
                    nameSearch = sc.nextLine();
                    for (Device device : devices) {
                        if (device.getName().equals(nameSearch)) {
                            devices.remove(device);
                        } else {
                            System.out.printf("Device with name \"%s\" not found\n", device.getName());
                        }
                    }
                    break;
                case "4":
                    System.out.println("Search device: ");
                    nameSearch = sc.nextLine();
                    for (Device device : devices) {
                        if (device.getName().equals(nameSearch)) {
                            System.out.printf("Device with name \"%s\" found\n", device.getName());
                        } else {
                            System.out.printf("Device with name \"%s\" not found\n", device.getName());
                        }
                    }
                    break;
                case "5":
                    System.out.println("Create new linked list.");
                    LinkedList<String> listNameDevices = new LinkedList<>();
                    for (int i = 0; i < devices.size(); i++) {
                        listNameDevices.add(devices.get(i).getName());
                    }
                    System.out.println("List: " + listNameDevices);
                    break;
                case "6":
                    System.out.println("Sort devices by name");
                    TreeSet treeSet = new TreeSet();
                    treeSet.stream().sorted().forEach((device) -> {
                    });
                    break;
                case "7":
                    System.out.println("Print devices by name");

                    for (int i = 0; i < devices.size(); i++) {
                        if (devices.get(i).getName().equals("")) {}
                    }
                    System.out.println(devices.toString());
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
//                    throw new IllegalStateException("Unexpected value: " + choice);


            }
        }

    }

    private Device createDevice(String name) {
        Device device = new Device();
        device.setName(name);
        device.setHeight(Double.parseDouble(roundValue(randomDouble(1.0, 10.0))));
        device.setLength(Double.parseDouble(roundValue(randomDouble(1.0, 200.0))));
        device.setWidth(Double.parseDouble(roundValue(randomDouble(1.0, 10.0))));
        device.setWeight(Double.parseDouble(roundValue(randomDouble(100.0, 1000.0))));
        device.setVoltage(Double.parseDouble(roundValue(220.0)));
        device.setCurrent(Double.parseDouble(roundValue(randomDouble(1.0, 10.0))));
        device.setFrequency(Double.parseDouble(roundValue(50.0)));
        return device;

    }
}
