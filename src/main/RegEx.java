/**
 * @author ssingan on 8/16/15.
 */
public class RegEx {

    public static void main(String[] args) {
        System.out.println("\"aa\", \"a\": " + (isMatch("aa", "a") ? "true" : "false"));
        System.out.println("\"aa\", \"aa\": " + (isMatch("aa", "aa") ? "true" : "false"));
        System.out.println("\"aa\", \"aa*\": " + (isMatch("aa", "aa*") ? "true" : "false"));
        System.out.println("\"aa\", \"a*\": " + (isMatch("aa", "a*") ? "true" : "false"));
        System.out.println("\"aa\", \"a*c*b*\": " + (isMatch("aa", "a*c*b*") ? "true" : "false"));
        System.out.println("\"aa\", \"a*b\": " + (isMatch("aabc", "a*b") ? "true" : "false"));
        System.out.println("\"aa\", \"a*bc*\": " + (isMatch("aa", "a*bc*") ? "true" : "false"));
        System.out.println("\"ab\", \"abc*\": " + (isMatch("ab", "abc*") ? "true" : "false"));
        System.out.println("\"ac\", \"ab*c*\": " + (isMatch("ac", "ab*c") ? "true" : "false"));
        System.out.println("\"abc\", \"ab*bc*\": " + (isMatch("abc", "ab*bc") ? "true" : "false"));
        System.out.println("\"abc\", \"ab*bc*c\": " + (isMatch("abc", "ab*bc*c") ? "true" : "false"));
        System.out.println("File Regex: ");
        System.out.println("\"abc\", \"abc\": " + (isMatchFileRegex("abc", "abc") ? "true" : "false"));
        System.out.println("\"abc\", \"ab?\": " + (isMatchFileRegex("abc", "ab?") ? "true" : "false"));
        System.out.println("\"abc\", \"ab*\": " + (isMatchFileRegex("abc", "ab*") ? "true" : "false"));
        System.out.println("\"abcd\", \"ab*cd\": " + (isMatchFileRegex("abcd", "ab*cd") ? "true" : "false"));
        System.out.println("\"abcdcd\", \"ab*cd\": " + (isMatchFileRegex("abcdcd", "ab*cd") ? "true" : "false"));
        System.out.println("\"abcd\", \"ab*cd*****\": " + (isMatchFileRegex("abcd", "ab*cd*****") ? "true" : "false"));


    }

    public static boolean isMatch(String string, String regex) {

        int stringPos = 0;
        int regexPos = 0;
        while (stringPos < string.length() && regexPos< regex.length()) {

            if (regexPos < regex.length()-1 && regex.charAt(regexPos+1) == '*') {
                while(stringPos < string.length() && string.charAt(stringPos) == regex.charAt(regexPos)) {
                    stringPos++;
                }
                regexPos +=2;
                while(regexPos < regex.length() && regex.charAt(regexPos) == string.charAt(stringPos - 1)) {
                    regexPos++;
                }
            } else {
                if (string.charAt(stringPos) != regex.charAt(regexPos)) {
                    return false;
                } else {
                    regexPos++;
                    stringPos++;
                }
            }
        }

        if (stringPos < string.length()) {
            return false;
        }

        while (regexPos < regex.length()-1 && regex.charAt(regexPos+1) == '*') {
            regexPos +=2;
        }

        return !(regexPos < regex.length());




    }



    public static boolean isMatchFileRegex(String string, String regex) {
        int stringPos =string.length()-1;
        int regexPos = regex.length()-1;

        while (stringPos >=0 && regexPos >= 0) {
            if ((string.charAt(stringPos) == regex.charAt(regexPos)) || regex.charAt(regexPos) == '?') {
                stringPos--;
                regexPos--;
            } else {
                if (regex.charAt(regexPos) == '*') {
                    while (regexPos >= 0 && regex.charAt(regexPos) == '*') {
                        regexPos--;
                    }

                    if (regexPos < 0) {
                        return true;
                    }

                    while (stringPos >=0 && regex.charAt(regexPos) != string.charAt(stringPos)) {
                        stringPos--;
                    }
                } else {
                    return false;
                }

            }
        }

        if (stringPos >=0) {
            return false;
        }

        while(regexPos>=0 && regex.charAt(regexPos) == '*') {
            regexPos--;
        }

        return (regexPos <0);

       /* while (stringPos < string.length() && regexPos < regex.length()) {

            if ((string.charAt(stringPos) == regex.charAt(regexPos)) || regex.charAt(regexPos) == '?') {
                stringPos++;
                regexPos++;
            } else {
                if (regex.charAt(regexPos) == '*') {

                    if (regexPos == regex.length()-1) {
                        return true;
                    }

                    while (stringPos < string.length() && string.charAt(stringPos) != regex.charAt(regexPos + 1)) {
                            stringPos++;
                    }
                    regexPos++;

                } else {
                    return false;
                }
            }


        }


        if (stringPos < string.length()) {
            return false;
        }

        while (regexPos < regex.length() && regex.charAt(regexPos) == '*') {
            regexPos++;
        }

        return !(regexPos <regex.length());*/
    }
}
