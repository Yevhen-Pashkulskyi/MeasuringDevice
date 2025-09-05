package view;

public class View {
    public void showMenu() {
        System.out.print("""
                1. Зробити вимір
                2. Увімкнути прилад
                0. Вихід з програми
                Зробити вибір: """);
    }

    public void listOfMeasurements(){
        System.out.print("""
                1.Виміряти вольтаж
                0.Вихід в попереднє меню
                Зробити вибір: """);
    }
}
