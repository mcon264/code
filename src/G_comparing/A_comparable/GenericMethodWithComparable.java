package G_comparing.A_comparable;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodWithComparable {
    static void main() {
        List<String> strings = List.of("car", "bus", "train", "taxi");
        IO.println(max(strings));

        List<Integer> integers = List.of(5, 1, 7, 3, 6);
        IO.println(max(integers));

        /*
        Why does the header of the max method say <E extends Comparable<? super E>>
        instead of the more simple <E extends Comparable<E>> ?
        Answer: consider the following situation:
         */
        class Animal {}
        class Dog extends Animal implements Comparable<Animal> {
            public int compareTo(Animal other) {
                return 0; // dummy implementation
            }
        }
        List<Dog> dogs = new ArrayList<>();
        max(dogs);
        /*
        If the header of max simply said <E extends Comparable<E>>,
        the above line would not compile, since Dog does not implement Comparable<Dog>.
         */
    }

    // Returns the maximum element in the list according to the elements' natural order.
    // Examples of things we can pass to this method: List<Integer>, ArrayList<String>
    // Examples of things we cannot pass to this method: List<Scanner>
    public static <E extends Comparable<? super E>> E max(List<E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        E max = list.getFirst(); // equivalent to: list.get(0);

        for (E e : list) {
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }

        return max;
    }
}
