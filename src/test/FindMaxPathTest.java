import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author svcheena on 7/24/15.
 */
public class FindMaxPathTest {

    FindMaxPath maxPath;

    @BeforeMethod
    public void setUp() throws Exception {

        maxPath = new FindMaxPath();
    }



    @Test
    public void testFindMaxPath() {
        int[] array = {5, 4, 12, 3, 11, 7, 2, 8, 1, 9};

        Assert.assertEquals(maxPath.findMaxSum(array), 36, "Test for a given input");
    }

    @AfterMethod
    public void tearDown() throws Exception {

    }
}