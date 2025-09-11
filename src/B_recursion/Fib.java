void main() {
    IO.println(fib(4)); // 3
    IO.println(fib(7)); // 13
}

// n       0  1  2  3  4  5  6   7   8 ...
// fib(n)  0  1  1  2  3  5  8  13  21 ...
// Pattern: each Fibonacci number is the sum of the
// previous two. The sequence begins with 0 and 1.
int fib(int n) {
    if (n < 0) {
        throw new IllegalArgumentException();
    }

    if (n == 0 || n == 1) {
        return n;
    } else {
        return fib(n - 2) + fib(n - 1);
    }
}