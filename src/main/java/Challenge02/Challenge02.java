package Challenge02;

import java.util.ArrayList;
import java.util.ListIterator;

public class Challenge02 {



    public String fixPriceLabel(String inputLabelString) {

        Label thisLabel = new Label(inputLabelString);
        int positionOfHighestValue = thisLabel.getPositionOfHighestPriceValue();

        for (int i = positionOfHighestValue - 1 ; i >= 0 ; i--) {
            thisLabel.removePriceAtLabelPosition(i);
        }

        boolean foundOne = true;
        while ( foundOne ) {
            foundOne = false;
            int pricesCount = thisLabel.getPricesCount();
            boolean[] shouldBeDeleted =  new boolean[ pricesCount ];
            for ( int i = 0; i < pricesCount - 1; i++ ) {
                if ( thisLabel.getPriceAtLabelPosition( i ).getValue() <= thisLabel.getPriceAtLabelPosition( i + 1 ).getValue() ) {
                    shouldBeDeleted[ i ] = true;
                    foundOne = true;
                }
            }
            for ( int i = 0; i < pricesCount - 1; i++ ) {
                if ( shouldBeDeleted[ i ] ) {
                    thisLabel.removePriceAtLabelPosition( i );
                }
            }
        }


        if (thisLabel.getPricesCount() == 1) {
            thisLabel.getPriceAtLabelPosition(0).setChronologyText("Now");
        } else {
            thisLabel.getPriceAtLabelPosition(0).setChronologyText("Was");
            thisLabel.getPriceAtLabelPosition(thisLabel.getPricesCount() - 1).setChronologyText("now");
            for (int i = 1; i < thisLabel.getPricesCount() - 1; i++) {
                thisLabel.getPriceAtLabelPosition(i).setChronologyText("then");
            }
        }

        return thisLabel.toString();
    }

    class Price implements Comparable<Price> {

        private String chronologyText;
        private String valueText;
        private double value;

        Price( String priceText ){

            String[] splitPriceText = priceText.split( " " );

            chronologyText = splitPriceText[ 0 ];
            valueText = splitPriceText[ 1 ];
            value = Double.parseDouble( valueText.substring( 1 ) );
        }

        public String getChronologyText() {
            return chronologyText;
        }

        public void setChronologyText( String s ) {
            chronologyText = s;
        }

        public String getValueText() {
            return valueText;
        }

        public double getValue() {
            return value;
        }

        public String toString() {
            return chronologyText + " " + valueText;
        }

        public int compareTo(Price otherPrice ) {

            if ( this.getValue() < otherPrice.getValue() ) {
                return -1;
            } else if ( this.getValue() > otherPrice.getValue() ) {
                return 1;
            } else { return 0; }
        }

        public boolean isGreaterThan( Price otherPrice ) {
            return this.compareTo( otherPrice ) > 0;
        }

        public boolean isLessThan( Price otherPrice ) {
            return this.compareTo( otherPrice ) < 0;
        }

    }

    class Label {

        private ArrayList<Price> prices = new ArrayList<Price>();

        Label(String labelText) {
            String[] priceLabelTexts = labelText.split(", ");

            for (int label = 0; label < priceLabelTexts.length; label++) {
                Price priceToAdd = new Price(priceLabelTexts[label]);
                prices.add(priceToAdd);
            }
        }

        public int getPricesCount() {
            return prices.size();
        }

        public Price getPriceAtLabelPosition(int i) {
            return prices.get(i);
        }

        public void removePriceAtLabelPosition(int i) {
            prices.remove(i);
        }

        public int getPositionOfHighestPriceValue() {
            double highestValue = 0;
            int highestValueAtPosition = 0;

            for (int position = 0; position < this.getPricesCount(); position++) {
                double value = this.getPriceAtLabelPosition(position).getValue();
                if (value > highestValue) {
                    highestValue = value;
                    highestValueAtPosition = position;
                }
            }
            return highestValueAtPosition;
        }

        public String toString() {
            String labelString = "";
            for (int i = 0; i < prices.size(); i++) {
                labelString += prices.get(i).toString();
                if (i < prices.size() - 1) {
                    labelString += ", ";
                }
            }
            return labelString;
        }
    }
}
