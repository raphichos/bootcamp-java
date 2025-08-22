package module04.exercise03;

public non-sealed class USClock extends Clock{

    // Extra field: AM/PM indicator
    private String periodIndicator;

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setAfterMidDay(){
        this.periodIndicator = "PM";
    }

    public void setBeforeMidDay(){
        this.periodIndicator = "AM";
    }

    public void setPeriodIndicator(String periodIndicator) {
        this.periodIndicator = periodIndicator;
    }

    // Override setHour to enforce 12h logic
    public void setHour(int hour) {
        setBeforeMidDay(); // default = AM

        // If hour >12 and <=23 → PM, subtract 12
        if ((hour > 12) && (hour <= 23)){
            setAfterMidDay();
            this.hour = hour - 12;
        } else if (hour >= 24){
            this.hour = 0;
        } else {
            this.hour = hour;
        }
    }

    @Override
    Clock convert(Clock clock) {
        // Copy seconds and minutes directly
        this.second = clock.getSecond();
        this.minute = clock.getMinute();

        switch (clock){
            // If USClock: copy hour + period
            case USClock usClock -> {
                this.hour = usClock.getHour();
                this.periodIndicator = usClock.getPeriodIndicator();
            }

            // If BRLClock: delegate to setHour (12h conversion)
            case BRLClock brlClock -> this.setHour(brlClock.getHour());
        }
        return this; // Return updated USClock
    }

    @Override
    public String getTime() {
        // Add AM/PM indicator at the end
        return super.getTime() + " " + this.periodIndicator;
    }
}
