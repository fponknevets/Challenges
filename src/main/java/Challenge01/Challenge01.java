package Challenge01;

public class Challenge01 {

    public final static int SECOND = 1;
    public final static int MINUTE = 60 * SECOND;
    public final static int HOUR = 60 * MINUTE;
    public final static int DAY = 24 * HOUR;
    public final static int YEAR = 365 * DAY;

    public String formatTime(int seconds) {

        String result = "";

        if ( seconds >= YEAR ) {
            int yearcount = seconds / YEAR;
            result += Integer.toString(yearcount) + " year";
            result += yearcount > 1 ? "s" : "";
            seconds -= yearcount * YEAR;
        }

        if ( seconds >= DAY) {
            int daycount = seconds / DAY;
            if ( result.length() > 0 ) { result += ", "; }
            result += Integer.toString(daycount) + " day";
            result += daycount > 1 ? "s" : "";
            seconds -= daycount * DAY;
        }

        if ( seconds > 0 ){
            if ( result.length() > 0 ) { result += " and "; }
            result += Integer.toString(seconds) + " second";
            result += seconds > 1 ? "s" : "";
        }

        return result;

    }
}
