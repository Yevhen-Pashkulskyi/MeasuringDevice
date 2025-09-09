package util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Utility {
    // випадкове значення
    public static double randomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max + 1);
    }

    // округлення, але повертається строка
    public static String roundValue(double number) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        return new DecimalFormat("#.00", symbols).format(number);
    }
}
