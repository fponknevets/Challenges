
import Challenge02.Challenge02;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Challenge02Tests {

    @Test
    void was2Now1GivesWas2Now1(){
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Was £2, now £1" );
        assertThat( result , equalTo( "Was £2, now £1" ) );
    }
}
