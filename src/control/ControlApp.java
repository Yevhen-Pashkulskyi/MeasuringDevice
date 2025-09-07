package control;

import util.Utility;
import model.Device;

import java.util.*;

public class ControlApp {
    public void run() {
        Scanner sc = new Scanner(System.in);
        LinkedList<Device> devices = new LinkedList<>();
        String choice;
        String nameSearch;
        choice = sc.nextLine();
        switch (choice) {
            case "1":
                System.out.print("Enter the name of the device you want to create: ");
                devices.addFirst(createDevice(sc.nextLine()));
                System.out.printf("Device with name %s created", devices.getFirst().getName());
                break;
            case "2":
                System.out.println("Delete last device: ");
                System.out.printf("Device with name %s deleted", devices.getLast().getName());
                devices.removeLast();
                break;
            case "3":
                System.out.print("Enter the name of the device to delete: ");
                nameSearch = sc.nextLine();
                for (Device device : devices) {
                    if (device.getName().equals(nameSearch)) {
                        devices.remove(device);
                    } else {
                        System.out.printf("Device with name %s not found", device.getName());
                    }
                }
                break;
            case "4":
                System.out.println("Search device: ");
                nameSearch = sc.nextLine();
                for (Device device : devices) {
                    if (device.getName().equals(nameSearch)) {
                        System.out.printf("Device with name %s found", device.getName());
                    } else {
                        System.out.printf("Device with name %s not found", device.getName());
                    }
                }
                break;
            case "5":
                System.out.println("Create new linked list.");
                LinkedList<String> listNameDevices = new LinkedList<>();
                for(int i = 0; i < devices.size(); i++){
                    listNameDevices.add(devices.get(i).getName());
                }
                break;
            case "6":
                System.out.println("Sort devices by name");
                TreeSet treeSet = new TreeSet();
                treeSet.stream().sorted().forEach((device) -> {});
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);

        }

    }

    private Device createDevice(String name) {
        Device device = new Device();
        device.setName(name);
        device.setHeight(Double.parseDouble(Utility.roundValue(Utility.randomDouble(1.0, 10.0))));
        device.setLength(Double.parseDouble(Utility.roundValue(Utility.randomDouble(1.0, 200.0))));
        device.setWidth(Double.parseDouble(Utility.roundValue(Utility.randomDouble(1.0, 10.0))));
        device.setWeight(Double.parseDouble(Utility.roundValue(Utility.randomDouble(100.0, 1000.0))));
        device.setVoltage(Double.parseDouble(Utility.roundValue(220.0)));
        device.setCurrent(Double.parseDouble(Utility.roundValue(Utility.randomDouble(1.0, 10.0))));
        device.setFrequency(Double.parseDouble(Utility.roundValue(50.0)));
        return device;

    }
}
