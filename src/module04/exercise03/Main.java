package module04.exercise03;

public class Main {


    public static void main(String[] args) {
        // Create a Brazilian clock (24h format)
        Clock brlclock = new BRLClock();

        // Set time: 13:00:00 (1 PM in Brazil format)
        brlclock.setSecond(0);
        brlclock.setMinute(0);
        brlclock.setHour(13);

        // Print Brazilian clock → "13:00:00"
        System.out.println(brlclock.getTime());

        // Convert BRL clock to US clock and print
        System.out.println(new USClock().convert(brlclock).getTime());
    }

}
