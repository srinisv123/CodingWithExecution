package main;

/**
 * @author ssingan on 7/15/15.
 */
public class IsNumber {

    /*
 * Returns true if the input string is a number and false otherwise
 */

    // 1000. => true, what ever you like, just write down your assumption
    // 1
    // ""
    // 10.2.2
    // -1
    public boolean isNumber(String toTest)
    {
        // implementation here

        char[] chars = toTest.toCharArray();
        if (chars.length ==0) {
            return false;
        }

        boolean seenDecimal = false;
        for(int i=0; i< chars.length; i++) {

            if (chars[i] == '-')
            {
                if (i != 0) {
                    return false;
                } else {
                    continue;
                }
            }

            if (chars[i] == '.') {
                if (!seenDecimal) {
                    seenDecimal = true;
                } else {
                    return false;
                }
            }

            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }

        }

        return true;

    }
}
