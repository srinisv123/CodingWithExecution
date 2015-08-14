import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author ssingan on 8/6/15.
 */
public class ArrayOfArrayIteratorTest {

    ArrayOfArrayIterator arrayOfArrayIterator;
    @BeforeTest
    public void setUp() {

        int[][] elements = {
                {},
                {1,2},
                {},
                {4,5,6},
                {},
                {7,8,9},
                {},
                {},
        };

        arrayOfArrayIterator = new ArrayOfArrayIterator(elements);

    }


    @Test
    public void testHas_next() throws Exception {

        while(arrayOfArrayIterator.has_next()) {
            int item = arrayOfArrayIterator.next();
            System.out.print(item + " ");
            if(item %2 == 0) {
                arrayOfArrayIterator.remove();
            }
        }
        System.out.println("\n new result: \n");
        int[][] result = arrayOfArrayIterator.getRawElements();

        ArrayOfArrayIterator newArrayOfIterator = new ArrayOfArrayIterator(result);
        while(newArrayOfIterator.has_next()) {
            int item = newArrayOfIterator.next();
            System.out.print(item + " ");
        }

    }
}