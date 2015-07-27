import java.util.ArrayList;

/**
 *
 We're going to be implementing a simple CSV parsing library.
 There are two things to focus on. The first (and most importantly)
 is actually parsing the CSV format. The second is making a
 clean API that another engineer would enjoy using.

 Because we are doing this on coderpad, you may pass in each line
 of the file as a string in an array instead of performing actual IO.

 Here are the specifications that we will be following.
 Please read through this carefully.
 https://www.dropbox.com/s/whonai6ki6npewv/Screenshot%202014-09-08%2016.13.02.png?dl=0

 You may assume that the CSV file is correctly formatted.

 Given the following strings:
 'John,Smith,john.smith@gmail.com,Los Angeles,1'
 'Jane,Roberts,janer@msn.com,"San Francisco, CA",0'
 '"Alexandra """"Alex""",Menendez,alex.menendez@gmail.com,Miami,1'

 An ideal parse will look like this:

 [['John', 'Smith', 'john.smith@gmail.com', 'Los Angeles', '1'],
 ['Jane', 'Roberts', 'janer@msn.com', 'San Francisco, CA', '0'],
 ['Alexandra ""Alex"', 'Menendez', 'alex.menendez@gmail.com', 'Miami', '1']]

 * @author svcheena on 7/25/15.
 */
public class CSVParser {

    public ArrayList<ArrayList<String>> parseCSV(ArrayList<String> lines) {

        ArrayList<ArrayList<String>> finalValues = new ArrayList<>();
        for (String line : lines) {

            char[] characters = line.toCharArray();

            ArrayList<String> tokens = new ArrayList<>();
            StringBuilder token = new StringBuilder();

            boolean seenDoubleQuotes = false;
            boolean consumedQuotes = false;

            for (int index =0; index<characters.length; index++) {

                Character c= characters[index];
                Character n = 'a';

                //Get the next character.
                if (index<characters.length-1) {
                    n = characters[index+1];
                }


                // If double quotes
                if (c =='"') {
                    // If already seen, set false, else set true;
                    if (seenDoubleQuotes) {

                        // Now check if the next one is also quotes
                        if (n =='"' && !consumedQuotes) {

                            token.append(c);
                            consumedQuotes = true;
                            continue;
                        }

                        if (consumedQuotes) {
                            consumedQuotes = false;
                            continue;
                        }

                        seenDoubleQuotes = false;
                    } else {
                        seenDoubleQuotes = true;
                    }
                    continue;
                }


                if (c == ',') {
                    if(seenDoubleQuotes) {
                        token.append(c);
                        continue;
                    }
                    tokens.add(token.toString());
                    token = new StringBuilder();
                } else {
                    token.append(c);
                }
            }

            tokens.add(token.toString());
            finalValues.add(tokens);
        }

        return finalValues;
    }

}
