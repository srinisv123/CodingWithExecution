
import java.util.IllegalFormatCodePointException;

/**
 * CTCI 1.3: Replace spaces with %20, inplace
 * @author svcheena on 7/11/15.
 */
public class EncodeSpacesInString {


    public static void main(String[] args) {
        EncodeSpacesInString encodeSpacesInString = new EncodeSpacesInString();

        System.out.println(encodeSpacesInString.encodeSpacesInStringInPlace("Hi".toCharArray(), 2));
        System.out.println(encodeSpacesInString.encodeSpacesInStringInPlace("Hi This is Srini.      ".toCharArray(), 17));

    }


    public char[] encodeSpacesInStringInPlace(char[] inputString, int trueLength) {
        if (trueLength > inputString.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int lastChar = trueLength -1;
        int currentChar = inputString.length -1;

        while (lastChar >=0) {


            if (inputString[lastChar--] == ' ') {
                inputString[currentChar--] = '0';
                inputString[currentChar--] = '2';
                inputString[currentChar--] = '%';
            } else {
                inputString[currentChar--] = inputString[lastChar+1];
            }
        }

        return inputString;

    }
}
