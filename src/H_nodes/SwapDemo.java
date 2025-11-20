package H_nodes;

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class SwapDemo {
    static void main() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);

        swap1(p1, p2);
        IO.println(p1); // (1, 2)
        IO.println(p2); // (3, 4)

        swap2(p1, p2);
        IO.println(p1); // (3, 4)
        IO.println(p2); // (1, 2)
    }

    static void swap1(Point a, Point b) {
        Point temp = a;
        a = b;
        b = temp;
        IO.println("inside swap1 " + a); // (3, 4)
        IO.println("inside swap1 " + b); // (1, 2)
    }

    static void swap2(Point a, Point b) {
        int temp = a.x;
        a.x = b.x;
        b.x = temp;

        temp = a.y;
        a.y = b.y;
        b.y = temp;
    }
}
