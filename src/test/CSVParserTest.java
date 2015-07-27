import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * @author svcheena on 7/25/15.
 */
public class CSVParserTest {

    CSVParser csvParser;

    @BeforeTest
    public void setUp() {
        csvParser = new CSVParser();
    }

    @Test
    public void testParseCSVWithNoQuotes() throws Exception {

        ArrayList<String> input = new ArrayList<>();
        input.add("John,Smith,john.smith@gmail.com,Los Angeles,1");

        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("John");
        tokens.add("Smith");
        tokens.add("john.smith@gmail.com");
        tokens.add("Los Angeles");
        tokens.add("1");

        expected.add(tokens);
        Assert.assertEquals(csvParser.parseCSV(input), expected, "Test with no quotes");
    }

    @Test
    public void testParseCSVWithQuotes() throws Exception {

        ArrayList<String> input = new ArrayList<>();
        input.add("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0");

        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Jane");
        tokens.add("Roberts");
        tokens.add("janer@msn.com");
        tokens.add("San Francisco, CA");
        tokens.add("0");

        expected.add(tokens);
        Assert.assertEquals(csvParser.parseCSV(input), expected, "Test with quotes");
    }

    @Test
    public void testParseCSVWithEmptyStrings() throws Exception {

        ArrayList<String> input = new ArrayList<>();
        input.add("John,Smith,john.smith@gmail.com,Los Angeles,1,");

        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("John");
        tokens.add("Smith");
        tokens.add("john.smith@gmail.com");
        tokens.add("Los Angeles");
        tokens.add("1");
        tokens.add("");


        expected.add(tokens);
        Assert.assertEquals(csvParser.parseCSV(input), expected, "Test with empty Strings quotes");
    }


    @Test
    public void testParseCSVWithManyQuotes() throws  Exception {

        ArrayList<String> input = new ArrayList<>();
        input.add("\"Alexandra \"\"\"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1");

        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Alexandra \"\"Alex\"");
        tokens.add("Menendez");
        tokens.add("alex.menendez@gmail.com");
        tokens.add("Miami");
        tokens.add("1");


        expected.add(tokens);
        Assert.assertEquals(csvParser.parseCSV(input), expected, "Test with many quotes");

    }
}