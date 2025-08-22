package module04.exercise03;

public non-sealed class BRLClock extends Clock{

    @Override
    public Clock convert(Clock clock) {
        // Copy seconds and minutes directly
        this.second = clock.getSecond();
        this.minute = clock.getMinute();
        // Pattern matching switch:
        switch (clock){
            // If clock is USClock:
            // Convert from 12h format → 24h
            case USClock usClock -> this.hour =(usClock.getPeriodIndicator().equals("PM")) ?
                                    usClock.getHour() + 12 :
                                    usClock.getHour();

            // If clock is BRLClock: just copy hour
            case BRLClock brlClock -> this.hour = brlClock.getHour();
        }
        return this; // Return updated BRLClock
    }

}
