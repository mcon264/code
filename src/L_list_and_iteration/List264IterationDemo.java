import L_list_and_iteration.ArrayList264;
import L_list_and_iteration.List264;

void main() {
    List264<String> list = new ArrayList264<>(); // or: new LinkedList264<>();
    list.add(0, "a");
    list.add(1, "b");
    list.add(2, "c");
    IO.println(list); // [a, b, c]

    // List264 inherits from Iterable, so we can have this enhanced for loop
    for (String s : list) {
        IO.print(s + " ");
    }

    IO.println();

    Iterator<String> iter = list.iterator();
    IO.println(iter.next()); // a
    IO.println(iter.next()); // b
    IO.println(iter.hasNext()); // true
    IO.println(iter.next()); // c
    IO.println(iter.hasNext()); // false
    IO.println(iter.next()); // throws NoSuchElementException
}

