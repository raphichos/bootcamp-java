package module07.tutorial2;

import java.math.BigDecimal;
import java.math.RoundingMode;

//BigDecimal

public class Main {


    public static void main(String[] args) {
        var value1 = new BigDecimal("56.36");
        var value2 = new BigDecimal("99.34");
        System.out.println(value2.divide(value1, 4, RoundingMode.HALF_UP));
    }

}
