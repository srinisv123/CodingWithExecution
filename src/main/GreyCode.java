/**
 * @author ssingan on 8/9/15.
 */
public class GreyCode {

    public static void main(String[] args) {
        GreyCode greyCode = new GreyCode();
        greyCode.greyCode("", 5);
    }

    public void greyCode(String prefix, int n) {
        if (n==0) {
            System.out.println(prefix);
            return;
        }

       /* if (n==1) {
            System.out.println(prefix + "0");
            System.out.println(prefix + "1");
            return;
        }*/

        greyCode(prefix + "0", n-1);
        greyCode(prefix + "1", n-1);

    }
}
