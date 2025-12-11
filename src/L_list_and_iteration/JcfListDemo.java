void main() {
    // Interface List<E>: a linear collection with indexes.
    // Methods: size, add, remove, get, set, indexOf,
    // lastIndexOf, sort, getFirst, getLast, addFirst,
    // addLast, removeFirst, removeLast (and more).
    // Implementations: ArrayList, LinkedList

    List<String> list = new ArrayList<>();
    IO.println(list); // []
    // list.set(0, "a"); // exception
    list.add(0, "a");
    IO.println(list); // [a]
    // list.add(2, "b"); // exception
    list.add(1, "b");
    IO.println(list); // [a, b]
    list.add(0, "c");
    IO.println(list); // [c, a, b]
    list.add(1, "d");
    IO.println(list); // [c, d, a, b]
    list.add(1, "e");
    IO.println(list); // [c, e, d, a, b]

    // IO.println(list.remove(5)); // exception
    IO.println(list.remove(1)); // e
    IO.println(list); // [c, d, a, b]

    // List inherits from Iterable, which has a method named iterator(),
    // which returns an Iterator object. Iterator has the following methods:
    // next(), hasNext(), and remove().
    Iterator<String> iter = list.iterator();
    IO.println(iter.next()); // c
    IO.println(iter.next()); // d
    IO.println(iter.hasNext()); // true
    IO.println(iter.next()); // a
    IO.println(iter.next()); // b
    IO.println(iter.hasNext()); // false
    // IO.println(iter.next()); // NoSuchElementException

    // re-create the Iterator to start again from the beginning
    iter = list.iterator();
    IO.println(iter.next()); // c
    IO.println(iter.next()); // d
    iter.remove(); // removes from the list the most recent element obtained from next(), d
    // iter.remove(); // IllegalStateException
    IO.println(list); // [c, a, b]
}