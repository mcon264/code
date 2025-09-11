/*
The stack records information about the currently-active method calls.

demo(0)  n: 0
---------------------------------
demo(1)  n: 1
---------------------------------
demo(2)  n: 2
---------------------------------
demo(3)  n: 3
---------------------------------
main
 */

/*
Output: 3 2 1 Blastoff! 1 2 3
 */
void main() {
    demo(3);
}

void demo(int n) {
    if (n == 0) { // base case
        IO.print("Blastoff! ");
    } else { // recursive case
        IO.print(n + " ");
        demo(n - 1);
        IO.print(n + " ");
    }
}