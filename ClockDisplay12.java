
public class ClockDisplay12{
    private NumberDisplay2 hours;
    private NumberDisplay2 minutes;
    private boolean esAm;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00 Am.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay2(12);
        minutes = new NumberDisplay2(60);
        esAm = true;
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay12(int hour, int minute, String amPm)
    {
        hours = new NumberDisplay2(12);
        minutes = new NumberDisplay2(60);
        if (amPm.toLowerCase() == "am"){esAm = true;}
        else if (amPm.toLowerCase() == "pm"){esAm = false;}
        setTime(hour, minute, amPm);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            // Chequea si es medianoche (12:00 AM) o mediodía (12:00 PM)
            if (hours.getValue() == 12) {
                esAm = !esAm; // Cambia entre AM y PM
            }
        }        
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour,
     * minute and if is am or pm.
     */
    public void setTime(int hour, int minute, String amPm)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        if (amPm.toLowerCase() == "am"){esAm = true;}
        else if (amPm.toLowerCase() == "pm"){esAm = false;}
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        String tiempo;
        if(esAm){tiempo=" Am ";}
        else{tiempo=" Pm ";}
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + tiempo;
    }
}
