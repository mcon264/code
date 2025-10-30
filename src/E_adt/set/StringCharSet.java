package E_adt.set;

/**
 * A CharSet whose elements are stored in a String. The capacity is theoretically unlimited;
 * in reality, though, the capacity is an int, so it can't go above Integer.MAX_VALUE.
 */
public class StringCharSet implements CharSet {
    // Representation: the characters of the set are stored in a String.
    private String s = "";

    @Override
    public boolean add(char ch) {
        if (contains(ch)) {
            return false;
        } else {
            s += ch;
            return true;
        }
    }

    @Override
    public boolean remove(char ch) {
        int index = s.indexOf(ch);

        if (index < 0) {
            return false;
        } else {
            s = s.substring(0, index) + s.substring(index + 1);
            return true;
        }
    }

    @Override
    public boolean contains(char ch) {
        return s.indexOf(ch) >= 0;
    }

    @Override
    public int size() {
        return s.length();
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return "{" + s + "}";
    }
}