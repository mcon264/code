/*

countdown(0)  n: 0
---------------------------------
countdown(1)  n: 1
---------------------------------
countdown(2)  n: 2
---------------------------------
countdown(3)  n: 3
---------------------------------
main
 */

/*
Output: 3 2 1 Blastoff! 1 2 3
 */
void main() {
    countDown(3);
}

void countDown(int n) {
    if (n == 0) {
        IO.print("Blastoff! ");
    } else {
        IO.print(n + " ");
        countDown(n - 1);
        IO.print(n + " ");
    }
}