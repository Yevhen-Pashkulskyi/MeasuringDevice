package utill;

import java.util.concurrent.ThreadLocalRandom;

public class Utility {
    public static double randomDouble() {
        return ThreadLocalRandom.current().nextDouble(0.0, 200.0);
    }
}
