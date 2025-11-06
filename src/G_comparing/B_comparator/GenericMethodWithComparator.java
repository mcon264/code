package G_comparing.B_comparator;

import java.util.Comparator;
import java.util.List;

public class GenericMethodWithComparator {
    static void main() {
        List<String> strings = List.of("plane", "balloon", "bird");
        Comparator<String> byLength = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        IO.println(max(strings, byLength)); // balloon

        IO.println(max(strings, Comparator.naturalOrder())); // plane

        List<Integer> integers = List.of(4, 5, 10, 6, 2, 7);
        Comparator<Number> numberComparator = new Comparator<>() {
            @Override
            public int compare(Number n1, Number n2) {
                return Double.compare(n1.doubleValue(), n2.doubleValue());
            }
        };
        IO.println(max(integers, numberComparator)); // 10
    }

    public static <E> E max(List<E> list, Comparator<? super E> comparator) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        E max = list.getFirst();

        for (E e : list) {
            if (comparator.compare(e, max) > 0) {
                max = e;
            }
        }

        return max;
    }
}
