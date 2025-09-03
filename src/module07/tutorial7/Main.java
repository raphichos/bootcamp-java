package module07.tutorial7;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable inc = () -> {
            for (int i = 0; i < 100; i++) {
                number.incrementAndGet();
            }
        };

        Runnable dec = () -> {
            for (int i = 0; i > -100; i--) {
                number.decrementAndGet();
            }
        };

        Runnable show = () -> {
            for (int i = 0; i < 250; i++) {
                System.out.println(number);
            }
        };

        var execInc = new Thread(inc);
        execInc.start();
        var execDec = new Thread(dec);
        execDec.start();
        var execShow = new Thread(show);
        execShow.start();

    }

}
