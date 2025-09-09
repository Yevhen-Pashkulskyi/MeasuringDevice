package view;

import model.Device;

import java.util.LinkedList;
import java.util.List;

public class View {
    public String showMenu() {

        return new String("""
                1. Додати елемент у початок списку
                2. Видалити останній елемент
                3. Видалити елемент з певним значенням деякого атрибуту
                4. Перевірити чи входить елемент у список
                5. Отримати з списку новий список з певним значенням атрибуту
                6. Відсортувати список за зменшенням деякого атрибуту
                7. Надрукувати характеристику обраного приладу
                8. Вивести список усіх приладів
                0. Exit
                Оберіть дію: 
                """);
    }

    public String showListDevices(LinkedList<Device> devices) {
        String nameDevices = "";
        for (Device device : devices){
            nameDevices += device.getName() + "\n";
        }

        return nameDevices;
    }
}
