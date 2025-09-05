package view;

public class View {
    public void showMenu() {
        System.out.print("""
                1. Увімкнути прилад
                2. Зробити вимір
                3. Вимкнути прилад
                0. Вихід з програми
                Зробити вибір: """);
    }

    public void listOfMeasurements(){
        System.out.print("""
                1. Виміряти вольтаж
                2. Виміряти спротив
                0. Вихід в попереднє меню
                Зробити вибір: """);
    }
}
