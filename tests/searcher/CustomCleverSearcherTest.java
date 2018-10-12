package searcher;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by u1773783 on 02/10/2018.
 */
class CustomCleverSearcherTest extends CustomSearcherTest{

    protected Searcher createSearcher(int[] array, int index) throws IndexingError {
        return new CleverSearcher(array,index);
    }

}