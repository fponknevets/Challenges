package Challenge02;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Challenge02 {



    public String fixPriceLabel(String s) {

        String fixedLabel = "";

        String[] labels = s.split( ", " );
        ArrayList splitLabels = new ArrayList();

        for ( int i = 0 ; i < labels.length ; i++ ) {
            splitLabels.add( (String[]) labels[ i ].split(" " ) );
        }

        for ( int i = 0 ; i < splitLabels.size() ; i++ ) {
            String[] label = (String[]) splitLabels.get( i );
            String time = label[ 0 ];
            String val = label[ 1 ];
            fixedLabel += time + " " + val;

            if ( i < splitLabels.size() - 1 ) {
                fixedLabel += ", ";
            }

        }

        return fixedLabel;
    }
}
