package searcher;

/**
 * @author Alistair Haslam
 * @version 1.0
 * @date 12/10/2018
 *
 * Created by u1773783 on 02/10/2018.
 */

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
        //Declares shortArray length of k which holds the first k elements which is then sorted.
        int[] shortArray = new int[k];
        for(int count = 0; count < shortArray.length; count ++)
        {
            shortArray[count] = array[count];
        }
        Arrays.sort(shortArray);

        /*
         * Cycles through the randomised array from element k to the end of the array
         */
        for(int i = shortArray.length; i < array.length; i++) {

            /*Checks to see if Array[i] is the largest element in shortArray. If so will insert Array[i]
             *in the end and shift the other values down.
             */
            if (array[i] >= shortArray[shortArray.length - 1]) {
                for (int x = 0; x < shortArray.length - 1; x++) {
                    shortArray[x] = shortArray[x + 1];              //Shifts shortArray values down.
                }
                shortArray[shortArray.length - 1] = array[i];
            } else {
                //Cycle through the small array
                for (int n = 0; n < shortArray.length; n++) {
                    //If Array[i] is smaller than the current shortArray[0] then break this loop.
                    if(array[i] < shortArray[0]){
                        break;
                    }
                    //Find the position of Array[i] in the shortArray. Shift the elements from the Array[n -1]
                    //position down and insert Array[i] in the correct place.
                    if (array[i] < shortArray[n + 1]) {

                        for (int x = 0; x < n; x++) {
                            shortArray[x] = shortArray[x + 1];
                        }
                        shortArray[n] = array[i];
                        break;
                    }
                }
            }
        }
        return shortArray[0];       //Returns the kth element
    }
}
