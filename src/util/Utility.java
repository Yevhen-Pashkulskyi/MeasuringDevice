package util;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Utility {
    // випадкове значення
    public static double randomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }

    // округлення, але повертається строка
    public static String roundValue(double number) {
        return new DecimalFormat("#.00").format(number);
    }
}
