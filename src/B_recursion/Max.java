package B_recursion;

public class Max {
    static void main() {
        //           0  1  2  3  4
        int[] arr = {5, 7, 9, 8, 3};
        System.out.println(max(arr, 4)); // 3
        System.out.println(max(arr, 3)); // 8
        System.out.println(max(arr, 0)); // 9

        System.out.println(max(arr)); // 9
    }

    // returns the max element in arr
    public static int max(int[] arr) { // wrapper method
        if (arr.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        return max(arr, 0); // calls the recursive method with a start index of 0
    }

    /*
    = max({5, 3, 9, 8}, 0)
    = Math.max(5, max({5, 3, 9, 8}, 1))
    = Math.max(5, Math.max(3, max({5, 3, 9, 8}, 2)))
    = Math.max(5, Math.max(3, Math.max(9, max({5, 3, 9, 8}, 3))))
    = Math.max(5, Math.max(3, Math.max(9, 8)))
    = Math.max(5, Math.max(3, 9))
    = Math.max(5, 9)
    9
     */

    // return the max element in arr, starting from startIndex
    private static int max(int[] arr, int startIndex) {
        if (startIndex == arr.length - 1) {
            // base case: only one element left to look at
            return arr[startIndex];
        } else {
            // recursive case: result should be
            // Math.max(arr[startIndex], max of rest of array)

            // int maxOfRest = max(arr, startIndex + 1); // recursive call
            // return Math.max(arr[startIndex], maxOfRest);

            // concise way:
            return Math.max(arr[startIndex], max(arr, startIndex + 1));
        }
    }
  /*
               0  1  2  3  4
Suppose arr = {5, 7, 9, 8, 3}
  max(arr) 
= max(arr, 0)
= Math.max(5, max(arr, 1))
= Math.max(5, Math.max(7, max(arr, 2)))
= Math.max(5, Math.max(7, Math.max(9, max(arr, 3))))
= Math.max(5, Math.max(7, Math.max(9, Math.max(8, max(arr, 4)))))
= Math.max(5, Math.max(7, Math.max(9, Math.max(8, 3))))
= Math.max(5, Math.max(7, Math.max(9, 8)))
= Math.max(5, Math.max(7, 9))
= Math.max(5, 9)
= 9
  */
}
