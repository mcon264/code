package C_search_sort;

/*
Sorting: putting an array of elements into non-decreasing order.

Selection sort: sort a list of values by repeatedly putting
the smallest unplaced value into its final position.
On each pass, we select the min and put it in its proper place.

The algorithm in more detail:
- Look through the list to find the smallest value.
- Swap it so that it is at index 0.
- Look through the list to find the second-smallest value.
- Swap it so that it is at index 1.
- Look through the list to find the third-smallest value.
- Swap it so that it is at index 2.
- ...
- Repeat until all values are in their proper places.

original array: {12, 123, 1, 28, 183, 16}
after pass 1:   {1, | 123, 12, 28, 183, 16}
after pass 2:   {1, 12, | 123, 28, 183, 16}
after pass 3:   {1, 12, 16, | 28, 183, 123}
after pass 4:   {1, 12, 16, 28, | 183, 123}
after pass 5:   {1, 12, 16, 28, 123, | 183}

(After each pass, the elements to the left of the bar
are in their final positions.)

With selection sort, we always have to perform n - 1 passes
for an array of length n. Even if the array happens to be
sorted already.
 */

import java.util.Arrays;

public class SelectionSort {
    static void main() {
        int[] nums = {12, 123, 1, 28, 183, 16};
        IO.println("Before: " + Arrays.toString(nums));
        selectionSort(nums);
        IO.println("After: " + Arrays.toString(nums));
    }

    public static void selectionSort(int[] a) {
        // perform a.length - 1 passes
        for (int i = 0; i < a.length - 1; i++) {
            // find the index of min starting from index i
            int indexOfMin = getIndexOfMin(a, i);

            // swap a[indexOfMin] with a[i],
            // thereby moving the min to its proper place
            swap(a, i, indexOfMin);

            // IO.println("After pass " + (i + 1) + ": " + Arrays.toString(a));
        }
    }

    // returns the index of the smallest element starting from startIndex
    private static int getIndexOfMin(int[] a, int startIndex) {
        int indexOfMin = startIndex;

        for (int i = startIndex + 1; i < a.length; i++) {
            if (a[i] < a[indexOfMin]) {
                indexOfMin = i;
            }
        }

        return indexOfMin;
    }

    // swaps arr[index1] with arr[index2]
    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}