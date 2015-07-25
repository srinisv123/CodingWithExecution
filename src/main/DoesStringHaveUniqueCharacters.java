
import java.util.Arrays;
import java.util.HashSet;

/**
 * CTCI 1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional
 * data structures
 * @author svcheena on 7/11/15.
 */
public class DoesStringHaveUniqueCharacters {

    public static void main(String[] args) {

        DoesStringHaveUniqueCharacters doesStringHaveUniqueCharacters = new DoesStringHaveUniqueCharacters();


        System.out.println(doesStringHaveUniqueCharacters.isStringUniqueWithHashSet("abcdefe"));
        System.out.println(doesStringHaveUniqueCharacters.isStringUniqueWithoutAdditionalDataStructure("abcdefe"));

        System.out.println(doesStringHaveUniqueCharacters.isStringUniqueWithHashSet(""));
        System.out.println(doesStringHaveUniqueCharacters.isStringUniqueWithoutAdditionalDataStructure(""));

        System.out.println(doesStringHaveUniqueCharacters.isStringUniqueWithHashSet("wert"));
        System.out.println(doesStringHaveUniqueCharacters.isStringUniqueWithoutAdditionalDataStructure("wert"));


    }



    public boolean isStringUniqueWithHashSet(String testString) {

        // Extract characters from the String and put in a hashset. If there is a repetition, return false.
        HashSet<Character> hashset = new HashSet<>();

        for (int i=0 ;i< testString.length() ; i++) {
            if (hashset.contains(testString.charAt(i))) {
                return false;
            } else {
                hashset.add(testString.charAt(i));
            }

        }
        return true;
    }

    public boolean isStringUniqueWithoutAdditionalDataStructure(String testString) {


        // Tokenize the string
        char[] tokenizedCharacters = testString.toCharArray();

        if (tokenizedCharacters.length <=1) {
            return true;
        }

        // Sort the String
        Arrays.sort(tokenizedCharacters);

        // scan to check adjacent
        char prev = tokenizedCharacters[0];
        boolean firstTime = true;
        for(char current : tokenizedCharacters) {
            if (firstTime) {
                firstTime = false;
                continue;
            }

            if (current == prev) {
                return false;
            } else {
                prev = current;
            }
        }

        return true;
    }



}
