package Challenge01;

public class Challenge01 {

    final static int SECOND = 1;
    final static int MINUTE = 60 * SECOND;
    final static int HOUR = 60 * MINUTE;
    final static int DAY = 24 * HOUR;
    final static int YEAR = 365 * DAY;

    public String formatTime(int i) {

        String result = Integer.toString(i) + " second";
        result += i > 1 ? "s" : "";
        
        return result;

    }
}
