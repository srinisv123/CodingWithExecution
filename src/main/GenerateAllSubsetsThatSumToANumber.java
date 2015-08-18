import java.util.ArrayList;

/**
 * @author ssingan on 8/14/15.
 */
public class GenerateAllSubsetsThatSumToANumber {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> allList = new ArrayList<>();

        System.out.println(countAllSubsets(new int[]{1, 2, 3, 4, -1, 9, -7, 0}, 0, 0, list));
        generateAllSubsets(new int[]{1,2,3,4}, 0, allList);
    }


    public static int countAllSubsets(int[] array, int value, int currPos, ArrayList<Integer> list) {
        if (currPos == array.length-1 ) {

            if (array[currPos] == value) {
                list.add(value);
                System.out.println(list.toString());
                list.remove(new Integer(array[currPos]));

                return 1;
            } else {
                return 0;
            }

        }

        list.add(array[currPos]);

        int sum = 0;
        if (array[currPos] == value) {
            System.out.println(list.toString());
            sum ++;
        }


        sum += countAllSubsets(array, value-array[currPos], currPos+1, list);
        list.remove(new Integer(array[currPos]));
        sum +=  countAllSubsets(array, value, currPos+1, list);

        return sum;
    }


    public static void generateAllSubsets(int[] array, int currPos, ArrayList<Integer> list) {

        if (currPos > array.length-1) {
          //  list.add(array[currPos]);
           // System.out.println(list.toString());
          //  list.remove(new Integer(array[currPos]));
            return;
        }

        list.add(array[currPos]);
        System.out.println(list.toString());

        generateAllSubsets(array, currPos + 1, list);
        list.remove(new Integer(array[currPos]));
        generateAllSubsets(array, currPos + 1, list);


    }
}
