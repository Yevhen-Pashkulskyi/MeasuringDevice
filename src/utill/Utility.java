package utill;

import java.util.concurrent.ThreadLocalRandom;

public class Utility {
    public static double randomDouble(int min, int max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }
}
