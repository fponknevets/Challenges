
import Challenge01.Challenge01;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Challenge01Tests {

    @Test
    void oneSecondTest(){
        Challenge01 challenge01 = new Challenge01();
        String result = challenge01.formatTime(1);
        assertThat(result, equalTo("1 second"));
    }

    @Test
    void twoSecondsTest(){
        Challenge01 challenge01 = new Challenge01();
        String result = challenge01.formatTime(2);
        assertThat(result, equalTo("2 seconds"));
    }

    @Test
    void oneYearTest() {
        Challenge01 challenge01 = new Challenge01();
        String result = challenge01.formatTime(31536000);
        assertThat(result, equalTo("1 year"));
    }

    @Test
    void oneYearOneDayAndOneSecondTest() {
        Challenge01 challenge01 = new Challenge01();
        String result = challenge01.formatTime(31536000 + 86400 + 1 );
        assertThat(result, equalTo("1 year, 1 day and 1 second"));
    }

    @Test
    void twoYearsTwoDaysAndTwoSecondsTest() {
        Challenge01 challenge01 = new Challenge01();
        String result = challenge01.formatTime(( 31536000 * 2 ) + ( 86400 * 2 ) + 2 );
        assertThat(result, equalTo("2 years, 2 days and 2 seconds"));
    }

}
