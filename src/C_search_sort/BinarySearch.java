package C_search_sort;

/*
  0   1   2   3   4   5   6   7   8   9  10  11  12  13  14
[11, 18, 29, 37, 42, 49, 51, 63, 69, 72, 77, 82, 88, 91, 98]
 */
 
public class BinarySearch {
    static void main() {
        int[] arr = {11, 18, 29, 37, 42, 49, 51, 63, 69, 72, 77, 82, 88, 91, 98};
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
 
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
 
        if (value == arr[middleIndex]) {
            return middleIndex;
        } else if (value < arr[middleIndex]) {
            return binarySearchRecursive(arr, value, lowIndex, middleIndex - 1);
        } else { // that is, value > arr[middleIndex]
            return binarySearchRecursive(arr, value, middleIndex + 1, highIndex);
        }
    }
}