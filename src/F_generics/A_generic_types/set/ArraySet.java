package F_generics.A_generic_types.set;

import java.util.Objects;

// a generic class that implements a generic interface
public class ArraySet<E> implements MySet<E> {
    private final E[] elements;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArraySet(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    @Override
    public boolean add(E e) {
        if (isFull() || contains(e)) {
            return false;
        } else {
            elements[size] = e;
            size++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index < 0) {
            return false;
        } else {
            elements[index] = elements[size - 1]; // replace the element we wish to remove with the last element
            size--;
            return true;
        }
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);

            if (i < size - 1) {
                sb.append(", ");
            }
        }

        return sb.append("}").toString();
    }

    private int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(elements[i], o)) { // null-safe equality test
                return i;
            }
        }

        return -1;
    }
    // Objects.equals(a, b) returns:
    // - true if both a and b are null
    // - false if one is null and the other isn't
    // - the result of a.equals(b) otherwise
}