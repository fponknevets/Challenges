
import Challenge01.Challenge01;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Challenge01Tests {

    @Test
    void oneReturnsOneSecondTest(){

        Challenge01 challenge01 = new Challenge01();
        String result = challenge01.formatTime(1);
        assertThat(result, equalTo("1 second"));
    }

}
