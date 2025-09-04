import model.ext.Multimeter;

public class App {
    public static void main(String[] args) {
        Multimeter multimeter = new Multimeter("Brymen EVM-839",30.0,168.0,70.0,350.0,
                24,65,50,false);
        multimeter.showInfo();
    }
}
