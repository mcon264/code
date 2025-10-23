package E_adt;

record Point(int x, int y) {}

public class RecordDemo {
    void main() {
        Point p = new Point(5, 10);
        // error: IO.println(p.x);
        IO.println(p.x()); // 5
        IO.println(p.y()); // 10
        IO.println(p); // Point[x=5, y=10]

        Point other = new Point(5, 10);
        IO.println(p.equals(other)); // true
    }
}

/*
A record is a kind of class which acts as a transparent, immutable carrier of data.
    - transparent: everyone can see what a record is made of, and if you change this later, client code may break (unlike a private field in a class)
    - immutable: no setters allowed

A record's instance fields, called its components, are implicitly private and final.

A record implicitly has:
- a canonical constructor: a constructor with parameters for all components
- an accessor method for each component, named exactly as the component (no "get")
- a toString method returning a String containing the textual representation of all components
- an equals method that compares the contents of two objects of the record
- a hashCode method that returns an int derived from all the components. (More on hash codes in a few weeks.)

The implicit constructor and methods can be overridden, if desired.

Additional methods can be added, if desired.

Static fields may be written in the body of the record but not in the header.

Instance fields (that is, components) can only be written in the header.

All records implicitly extend java.lang.Record, which extends java.lang.Object.

A record cannot explicitly extend a class and cannot be extended.

A record may implement interfaces.


The above record is equivalent to the following class:

class Point {
    private final int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x() {
        return x;
    }

    int y() {
        return y;
    }

    @Override
    public String toString() {
        return "Point[x=" + x + ", y=" + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Point other && this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }
}
 */