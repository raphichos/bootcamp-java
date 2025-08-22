package module04.exercise03;

public sealed abstract class Clock permits BRLClock, USClock{

    // Common time fields for all clocks
    protected int hour;

    protected int minute;

    protected int second;

    // ====== Getters & Setters ======
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        // Validation attempt: hours should be 0–23
        if (hour >= 24){
            this.hour = 24;
            return;
        }
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        // Validation attempt: minutes should be 0–59
        if (minute >= 60){
            this.minute = 60;
            return;
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        // Same issue: seconds should be 0–59
        if (second >= 60){
            this.second = 60;
            return;
        }
        this.second = second;
    }

    // Formats a number with a leading zero if <10
    private String format(int value){
        return value < 9 ? "0" + value : String.valueOf(value);
    }

    // Returns time as HH:MM:SS
    public String getTime(){
        return format(hour) + ":" + format(minute) + ":" + format(second);
    }

    // Abstract method: each subclass must decide how to "convert" from another Clock into itself.
    abstract Clock convert(Clock clock);

}
