package control;

import model.Device;
import view.View;

import java.util.*;

import static javax.swing.JOptionPane.*;
import static util.Utility.*;

public class ControlApp {

    public void run() {
        View view = new View();

        LinkedList<Device> devices = new LinkedList<>();

        String choice;
        String nameSearch;
        boolean flag = true;

        while (flag) {
            choice = showInputDialog(null, view.showMenu(), "Меню", 3);
            if (choice == null) {
                break;
            } else if (choice.isEmpty()) {
                continue;
            }
            switch (choice) {

                case "1":
                    Device createDevice = createDevice(showInputDialog(null,
                            "Введіть ім'я приладу яке ви хочете створити", "Створення приладу", 1));
                    if (createDevice != null) {
                        devices.addFirst(createDevice);
                        showMessageDialog(null, "Прилад " + devices.getFirst().getName() + " створено");
                    } else {
                        showMessageDialog(null, "Назва приладу не може бути порожня",
                                "Попередження, поле вводу", ERROR_MESSAGE);
                    }
                    break;

                case "2":
                    if (!devices.isEmpty()) {
                        showMessageDialog(null, "Прилад " + devices.getLast().getName() + " видалено");
                        devices.removeLast();
                    } else {
                        showMessageDialog(null, "Список порожній");
                    }
                    break;

                case "3":
                    if (devices.isEmpty()) {
                        showMessageDialog(null, "Список порожній");
                        break;
                    }
                    nameSearch = checkingNameInput(devices, showInputDialog(null, showListDeviceName(devices) + "Введіть назву приладу",
                            "Видалення за назвою", 3));
                    if (nameSearch != null) {
                        for (Device device : devices) {
                            if (device.getName().equals(nameSearch)) {
                                showMessageDialog(null, "Прилад " + nameSearch + " видалено");
                                devices.remove(device);
                                break;
                            }
                        }
                    }
                    break;

                case "4":
                    if (devices.isEmpty()) {
                        showMessageDialog(null, "Список порожній");
                        break;
                    }
                    nameSearch = checkingNameInput(devices, showInputDialog(null, "Введіть назву приладу",
                            "Перевірка наявності", 3));
                    if (nameSearch != null) {
                        showMessageDialog(null, "Прилад " + nameSearch + " є в списку");
                    }
                    break;

                case "5":
                    if (devices.isEmpty()) {
                        showMessageDialog(null, "Список порожній");
                        break;
                    }

                    nameSearch = checkingNameInput(devices, showInputDialog(null,
                            "Введіть значення атрибуту, назва приладу",
                            "Список з певним атрибутом", 3));

                    if (nameSearch != null) {
                        LinkedList<Device> listNameDevices = createList(devices, nameSearch);
                        if (listNameDevices != null) {
                            showMessageDialog(null, "Список:\n" + showListDevices(listNameDevices).toString());
                        }
                    }
                    break;

                case "6":
                    if (!devices.isEmpty()) {
                        devices.sort(Comparator.comparing(Device::getName));
                        showMessageDialog(null, "Список відсортовано", "Сортування списку", 3);
                    } else {
                        showMessageDialog(null, "Список порожній");
                    }
                    break;

                case "7":
                    if (devices.isEmpty()) {
                        showMessageDialog(null, "Список порожній");
                        break;
                    }
                    StringBuilder showListGetName = showListDeviceName(devices);
                    nameSearch = checkingNameInput(devices, showInputDialog(null,
                            showListGetName + "\nВведіть назву приладу для отримання характеристик",
                            "Характеристики приладу", 3));

                    for (int i = 0; i < devices.size(); i++) {
                        if (devices.get(i).getName().equals(nameSearch)) {
                            showMessageDialog(null, devices.get(i).toString(),
                                    "Характеристика приладу", 1);
                            break;
                        }
                    }
                    break;

                case "8":
                    if (devices.isEmpty()) {
                        showMessageDialog(null, "Список порожній");
                    } else {
                        showMessageDialog(null, showListDevices(devices).toString(), "Список приладів", 3);
                    }
                    break;

                default:
                    showMessageDialog(null, "Невірний вибір спробуйте ще!", "Помилка", ERROR_MESSAGE);
                    break;
            }
        }

    }

    // метод створює девайс с рандомними значеннями крім назви приладу!
    private Device createDevice(String name) {
        if (name.isEmpty()) {
            return null;
        }
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

    private String checkingNameInput(LinkedList<Device> devices, String name) {
        if (name.isEmpty()) {
            showMessageDialog(null, "Не введено назву приладу", "Помилка", 0);
            return null;
        }
        for (Device device : devices) {
            if (device.getName().equals(name)) {
                return device.getName();
            }
        }
        showMessageDialog(null, "Приладу з назвою " + name + " не має в списку",
                "Помилка", ERROR_MESSAGE);
        return null;
    }

    // метод створює новий список за визначеним атрибутом
    private LinkedList<Device> createList(LinkedList<Device> devices, String nameSearch) {
        if (devices == null || devices.isEmpty() || nameSearch == null || nameSearch.isEmpty()) {
            return null;
        }
        LinkedList<Device> deviceList = new LinkedList<>();
        for (Device device : devices) {
            if (device.getName().equals(nameSearch)) {
                deviceList.add(device);
            }
        }
        return deviceList;
    }

    // метод для виводу списку імен
    private StringBuilder showListDeviceName(LinkedList<Device> devices) {
        StringBuilder nameDevices = new StringBuilder();
        for (Device device : devices) {
            nameDevices.append(device.getName()).append("\n");
        }
        return nameDevices;
    }

    // метод для виводу всіх приладів з характеристиками
    private StringBuilder showListDevices(LinkedList<Device> devices) {
        if (devices == null || devices.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Device device : devices) {
            stringBuilder.append(device.toString()).append("\n");
        }
        return stringBuilder;
    }
}
