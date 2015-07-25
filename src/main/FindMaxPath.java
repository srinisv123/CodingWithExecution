
// Hello world..


// input = [ 5, 4, 12, 3, 11, 7…]

/*
       5
     4  12
   3  11  7
 2   8   1  9

36: 5 + 12 + 11 + 8

valid move: 4 to 3 or 11
invalid move: 4 to 5 / 12 / 7 / 2


class FindMaxPath {

    public long findMaxSum(int[] input) {
        // your code goes here..
        int maxValue = 0;
        for(int i=0; i< input.length; i++) {
        int currentVal =input[i];
        int currentIndex = i;
        while ((int nextIndex = findNextValidIndex(currentIndex)) <= input.lenght-1) {
            if (nextIndex+1 <= input.lenght-1 && input[nextIndex+1] > input[nextIndex]) {
                currentIndex = nextIndex+1
            } else {
            currentIndex = nextIndex;
            }
        currentVal = currentVal + input[currentIndex];
        }

        if (currentVal > maxVal) {
        maxVal = currentVal;
        }
        }

        return maxVal;

        }

        int findCurrentLevel(int index) {
        if (index ==0) {
        return 0;
        }


        }


        int findNextValidNextIndex(int index) {
        return index + findCurrentLevel(index) +1;
        }

        */



public class FindMaxPath {


    public static void main(String[] args) {
        FindMaxPath findMaxPath = new FindMaxPath();
        int[] array = {5, 4, 12, 3, 11, 7, 2, 8, 1, 9};
        System.out.println("The max sum is: " + findMaxPath.findMaxSum(array));
    }

    public long findMaxSum(int[] array) {

       return maxSum(array, 0, 0);


    }

    public long maxSum(int[] array, int index, int currentLevel) {

        if (index > array.length-1) {
            return 0;
        }
        int nextIndex = findNextValidIndex(index, currentLevel);
        return array[index] + Long.max(maxSum(array, nextIndex, currentLevel+1), maxSum(array, nextIndex+1, currentLevel+1));

    }


    public int findNextValidIndex(int index, int level) {
        return index + level + 1;
    }
}