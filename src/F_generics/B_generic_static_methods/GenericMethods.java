package F_generics.B_generic_static_methods;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {
    static void main() {
        String[] arr = {"a", "b", "c", "d", "e"};
        IO.println(middle(arr));

        Integer[] integers = {1, 2, 3, 4, 5};
        IO.println(middle(integers));

        int[] ints = {1, 2, 3};
        // IO.println(middle(ints)); // doesn't compile

        List<String> stringList = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
        IO.println("original String list: " + stringList);

        swap(stringList, 0, 2);
        IO.println("list after swapping the elements at indexes 0 and 2: " + stringList);

        List<Number> numberList = List.of(1, 2.5, 3);
        IO.println(sum(numberList));
        List<Integer> integerList = List.of(1, 2, 3);
        IO.println(sum(integerList));
        List<Double> doubleList = List.of(1.5, 2.5, 3.5);
        IO.println(sum(doubleList));
        // IO.println(sum(stringList)); // doesn't compile
    }

    /**
     * Returns the element at the midpoint of arr (if arr.length is odd)
     * or the element right after the midpoint (if arr.length is even).
     */
    // Examples of things we can pass to this method: String[], Integer[]
    // Examples of things we cannot pass to this method: int[], double[]
    public static <E> E middle(E[] arr) {
        return arr[arr.length / 2];
    }

    /**
     * Swaps the element at index1 with the element at index2.
     */
    // Examples of things we can pass to this method: List<Scanner>, ArrayList<String>
    public static <E> void swap(List<E> list,
                                int index1, int index2) {
        E temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    // Can pass Number, Integer, Double to this method, because
    // Integer and Double inherit from Number.
    public static void whatever(Number n) {}

    // Can only pass a List<Number> or ArrayList<Number> to this method.
    // Cannot pass a List<Integer> or List<Double> or ArrayList<Integer>.
    // This is not unique to List; it is a general restriction
    // regarding generic types. As a result, this method is not very useful.
    /*
    public static double sum(List<Number> list) {
        double total = 0;

        for (Number element : list) {
            total += element.doubleValue();
        }

        return total;
    }
    */

    // Examples of things we can pass to this method: List<Number>, List<Integer>, ArrayList<Double>
    // Examples of things we cannot pass to this method: List<String>
    // "E extends Number" means that either E is Number or E inherits
    // from Number, even indirectly.
    public static <E extends Number> double sum(List<E> list) {
        double total = 0;

        for (E element : list) {
            total += element.doubleValue();
        }

        return total;
    }
}