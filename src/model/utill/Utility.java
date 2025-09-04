package model.utill;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utility {
    public static double random(){
        Random rand = new Random();
        return ThreadLocalRandom.current().nextDouble(0.0,200.0);
    }
}
