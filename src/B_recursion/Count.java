package B_recursion;

public class Count {
    static void main() {
        int[] arr = {11, 6, 7, 11, 3, 11};
        System.out.println(count(arr, 11)); // 3
    }

    /*
    count(arr, 11)
    = count(arr, 11, 0)
    = 1 + count(arr, 11, 1)
    = 1 + 0 + count(arr, 11, 2)
    = 1 + 0 + 0 + count(arr, 11, 3)
    = 1 + 0 + 0 + 1 + count(arr, 11, 4)
    = 1 + 0 + 0 + 1 + 0 + count(arr, 11, 5)
    = 1 + 0 + 0 + 1 + 0 + 1 + count(arr, 11, 6)
    = 1 + 0 + 0 + 1 + 0 + 1 + 0
    = 3
     */

    // returns the number of times that x appears in arr
    public static int count(int[] arr, int x) { // "wrapper" method
        return count(arr, x, 0); // call the recursive method
    }

    // counts the number of times x occurs in arr, starting from the 
    // given startIndex; ignores the elements before startIndex.
    private static int count(int[] arr, int x, int startIndex) {
        if (startIndex >= arr.length) {
            // base case: startIndex is beyond the last index of the
            // array, so there are no elements left to look at
            return 0;
        } 

        // perfectly good:
        // if (arr[startIndex] == x) {
        //     return 1 + count(arr, x, startIndex + 1);
        // } else {
        //     return count(arr, x, startIndex + 1);
        // }

        // a more concise way:
        return (arr[startIndex] == x ? 1 : 0)
                + count(arr, x, startIndex + 1);
    }
}