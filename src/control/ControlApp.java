package control;

import model.Device;
import view.View;

import javax.swing.*;
import java.util.*;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static util.Utility.*;

public class ControlApp {

    public void run() {
        View view = new View();

        LinkedList<Device> devices = new LinkedList<>();

        String choice;
        String nameSearch;
        boolean flag = true;

        while (flag) {
            choice = showInputDialog(null, view.showMenu());
            if (choice == null || choice.isEmpty()) {
                continue;
            }
            switch (choice) {
                case "1":
                    devices.addFirst(createDevice(showInputDialog("Введіть ім'я приладу яке ви хочете створити")));
                    showMessageDialog(null, "Прилад " + devices.getFirst().getName() + " створено");
                    break;
                case "2":
                    showMessageDialog(null, "Прилад " + devices.getLast().getName() + " видалено");
                    devices.removeLast();
                    break;
                case "3":
                    nameSearch = showInputDialog(null,view.showListDevices(devices)+ "Введіть ім'я приладу який потрібно видалити");
                    for (Device device : devices) {
                        if (device.getName().equals(nameSearch)) {
                            showMessageDialog(null, "Прилад " + nameSearch + " видалено");
                            devices.remove(device);
                            break;
                        }
                    }
                    showMessageDialog(null, "Приладу з таким ім'ям " + nameSearch + " немає");
                    break;
                case "4":
                    nameSearch = showInputDialog(null, "Введіть ім'я приладу для перевірки наявності");
                    for (Device device : devices) {
                        if (device.getName().equals(nameSearch)) {
                            showMessageDialog(null, "Прилад " + nameSearch + " є в списку");
                            break;
                        }
                    }
                    showMessageDialog(null, "Прилад " + nameSearch + " не має в списку");
                    break;
                case "5":
                    LinkedList<String> listNameDevices = new LinkedList<>();
                    for (int i = 0; i < devices.size(); i++) {
                        listNameDevices.add(devices.get(i).getName());
                    }
                    System.out.println("Список імен: " + listNameDevices);
                    break;
                case "6":
                    TreeSet treeSet = new TreeSet();
                    treeSet.stream().sorted().forEach((device) -> {
                    });
                    break;
                case "7":
                    String showListGetName = view.showListDevices(devices);
                    nameSearch = showInputDialog(null, showListGetName + "\nВведіть назву приладу для отримання характеристик");

                    for (int i = 0; i < devices.size(); i++) {
                        if (devices.get(i).getName().equals(nameSearch)) {
                            showMessageDialog(null, devices.get(i).toString());
                            break;
                        }
                    }
                    break;
                case "8":
                    showMessageDialog(null, devices.toString());
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    showMessageDialog(null,"Невірний вибір спробуйте ще!");
                    break;
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
