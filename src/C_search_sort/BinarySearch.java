package C_search_sort;

/*
mid = (low + high) / 2 [use integer division]

  0   1   2   3
[11, 18, 29, 37]

Searching for 29:
low   mid   high
 0     1      3
 2     2      3
Return 2.

  0   1   2   3   4   5   6   7   8   9  10  11  12  13  14
[11, 18, 29, 37, 42, 49, 51, 63, 69, 72, 77, 82, 88, 91, 98]

Search for 76:
low    mid   high
 0      7     14
 8     11     14
 8      9     10
10     10     10
10             9
Returns -1.

The algorithm stops when:
- we find the desired value, or
- when low > high

searching for 82:
low    mid   high
 0      7     14
 8     11     14
Return 11, since 82 is there.

searching for 77:
low    mid   high
 0      7     14
 8     11     14
 8      9     10
10     10     10
return 10, since 77 is at index 10
We only looked at 4 elements.
Linear search would've looked at 11 elements!

We keep dividing the problem size in half: 15 --> 7 --> 3 --> 1
This corresponds to log_2(n), where n = arr.length.
log_2(1,000,000) is approximately 20, which is amazing.
 */
 
public class BinarySearch {
    static void main() {
        int[] arr = {11, 18, 29, 37, 42, 49, 51, 63, 69, 72, 77, 82, 88, 91, 98};
        IO.println(binarySearchIterative(arr, 77));
    }

    // Given a *sorted* array and a value to search for, very efficiently
    // returns an index where the value appears in the array, or -1 if it
    // doesn't appear.
    public static int binarySearchIterative(int[] arr, int value) {
        int lowIndex = 0, highIndex = arr.length - 1;
 
        while (lowIndex <= highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;
            // doesn't work for super-large arrays due to integer overflow;
            // if interested in knowing why, and how to fix it, read more here:
            // https://research.google/blog/extra-extra-read-all-about-it-nearly-all-binary-searches-and-mergesorts-are-broken/
            // the fix looks something like this:
            // int distance = highIndex - lowIndex;
            // int halfDistance = distance / 2;
            // int middleIndex = lowIndex + halfDistance;

            if (value == arr[middleIndex]) {
                return middleIndex;
            } else if (value < arr[middleIndex]) {
                highIndex = middleIndex - 1;
            } else { // that is, value > arr[middleIndex]
                lowIndex = middleIndex + 1;
            }
        }
 
        return -1;
    }
 
    public static int binarySearchRecursive(int[] arr, int value) {
        return binarySearchRecursive(arr, value, 0, arr.length - 1);
    }
 
    private static int binarySearchRecursive(int[] arr,
                                            int value,
                                            int lowIndex,
                                            int highIndex) {
        if (lowIndex > highIndex) {
            return -1;
        }
 
        int middleIndex = (lowIndex + highIndex) / 2;
 
        if (value == arr[middleIndex]) {
            return middleIndex;
        } else if (value < arr[middleIndex]) {
            return binarySearchRecursive(arr, value, lowIndex, middleIndex - 1);
        } else { // that is, value > arr[middleIndex]
            return binarySearchRecursive(arr, value, middleIndex + 1, highIndex);
        }
    }
}