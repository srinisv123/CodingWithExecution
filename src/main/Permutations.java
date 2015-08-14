import java.util.Arrays;

/**
 * @author ssingan on 8/9/15.
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations permutations  = new Permutations();

        permutations.permutation(new int[]{1,2,3,4}, 0);
    }

    public void permutation(int[] array, int pos) {
        if (pos >= array.length-1) {
            System.out.println("One permutation : " + Arrays.toString(array));
            return;
        }

        for (int i = pos; i< array.length ; i++) {
            int temp = array[pos];
            array[pos] = array[i];
            array[i] = temp;
            permutation(array, pos+1);
            temp = array[pos];
            array[pos] = array[i];
            array[i] = temp;
        }
    }
}
