package searcher;

/**
 * Created by u1773783 on 02/10/2018.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class CleverSearcher extends Searcher {

    CleverSearcher(int[] array, int k) {
        super(array, k);
    }



    @Override
    public int findElement() throws IndexingError {
        int[] array = getArray();
        int k = getIndex();

        if (k <= 0 || k > array.length) {
            throw new IndexingError();
        }
    //Array is initilized to 0 by default
        int[] shortArray = new int[k];
        //Initialise the short array to the initial array
        for(int count = 0; count < shortArray.length; count ++)
        {
            shortArray[count] = array[count];
        }
        Arrays.sort(shortArray);
        //return shortArray[0];



        for(int i = shortArray.length; i < array.length; i++) {
            //Second loop to go through shortArray

            if (array[i] >= shortArray[shortArray.length - 1]) {
                for (int x = 0; x < shortArray.length - 1; x++) {
                    shortArray[x] = shortArray[x + 1];
                }
                shortArray[shortArray.length - 1] = array[i];
            } else {
                for (int n = 0; n < shortArray.length; n++) {
                    if(n != shortArray.length - 1) {
                        if (array[i] >= shortArray[n] && array[i] < shortArray[n + 1]) {
                        //Check if it is the first element
                        // if(n != shortArray.length) {
                        //shift previous numbers
                        for (int x = 0; x < n; x++) {
                            shortArray[x] = shortArray[x + 1];
                        }
                        // }
                        //insert new number
                        shortArray[n] = array[i];
                        //Arrays.sort(shortArray);
                        break;
                    }
                    }
                    //break;
                }
            }
        }
        return shortArray[0];
    }


}
