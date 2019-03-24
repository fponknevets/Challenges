package Challenge01;

public class Challenge01 {

    public final static int SECOND = 1;
    public final static int MINUTE = 60 * SECOND;
    public final static int HOUR = 60 * MINUTE;
    public final static int DAY = 24 * HOUR;
    public final static int YEAR = 365 * DAY;

    public static void main ( String [] arguments )
    {
        int seconds = Integer.parseInt( arguments[0] );
        System.out.println( formatTime( seconds ) );
    }

    public static String formatTime(int seconds) {

        String result = "";

        if (seconds >= YEAR) {
            int yearcount = seconds / YEAR;
            result += Integer.toString( yearcount ) + " year";
            result += yearcount > 1 ? "s" : "";
            seconds -= yearcount * YEAR;
        }

        if (seconds >= DAY) {
            int daycount = seconds / DAY;
            if (result.length() > 0) {
                result += ", ";
            }
            result += Integer.toString( daycount ) + " day";
            result += daycount > 1 ? "s" : "";
            seconds -= daycount * DAY;
        }

        if (seconds >= HOUR) {
            int hourcount = seconds / HOUR;
            if (result.length() > 0) {
                result += ", ";
            }
            result += Integer.toString( hourcount ) + " hour";
            result += hourcount > 1 ? "s" : "";
            seconds -= hourcount * HOUR;
        }

        if (seconds >= MINUTE) {
            int minutecount = seconds / MINUTE;
            if (result.length() > 0) {
                result += ", ";
            }
            result += Integer.toString( minutecount ) + " minute";
            result += minutecount > 1 ? "s" : "";
            seconds -= minutecount * MINUTE;
        }

        if (seconds > 0) {
            if (result.length() > 0) {
                result += " and ";
            }
            result += Integer.toString( seconds ) + " second";
            result += seconds > 1 ? "s" : "";
        }

        if ( result.contains( "," ) && ! result.contains( "and" ) ) {
            int lastcomma = result.lastIndexOf(",");
            String beforeAnd = result.substring( 0 , lastcomma );
            String afterAnd = result.substring( lastcomma + 1 );
            result = beforeAnd + " and" + afterAnd;
        }

        return result;

    }
}
