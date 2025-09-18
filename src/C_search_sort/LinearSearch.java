package C_search_sort;

public class LinearSearch {
    static void main() {
        //          0   1  2  3  4
        int[] a = {5, 10, 4, 7, 3};
        IO.println(linearSearch(a, 7)); // 3
        IO.println(linearSearch(a, 8)); // -1
    }

    // Given a (possibly unsorted) array and a value to search for,
    // returns an index where the value appears in the array, or -1
    // if it doesn't appear.
    public static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }
}
