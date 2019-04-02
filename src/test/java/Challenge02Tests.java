
import Challenge02.Challenge02;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class Challenge02Tests {

    @Test
    void onePrice(){
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Now £2" );
        assertThat( result , equalTo( "Now £2" ) );
    }

    @Test
    void twoPricesRightOrder() {
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Was £3, now £2" );
        assertThat( result , equalTo( "Was £3, now £2" ) );
    }

    @Test
    void twoPricesWrongOrder() {
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Was £2, now £3" );
        assertThat( result , equalTo( "Now £3" ) );
    }

    @Test
    void twoPricesTheSame() {
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Was £2, now £2" );
        assertThat( result , equalTo( "Now £2" ) );
    }

    @Test
    void threePricesRightOrder() {
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Was £3.55, then £2, now £1.01" );
        assertThat( result , equalTo( "Was £3.55, then £2, now £1.01" ) );
    }

    @Test
    void threePricesMiddleHighest() {
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Was £3.55, then £4, now £1.01" );
        assertThat( result , equalTo( "Was £4, now £1.01" ) );
    }

    @Test
    void threePricesLastHighest() {
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Was £3.55, then £4, now £10.01" );
        assertThat( result , equalTo( "Now £10.01" ) );
    }

    @Test
    void was2Now1GivesWas2Now1(){
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Was £2, now £1" );
        assertThat( result , equalTo( "Was £2, now £1" ) );
    }

    @Test
    void fourPricesMiddleTwoLowerThanCurrent() {
        Challenge02 challenge02 = new Challenge02();
        String result = challenge02.fixPriceLabel( "Was £10, then £6, then £4, now £8" );
        assertThat( result , equalTo( "Was £10, now £8" ));
    }



}
