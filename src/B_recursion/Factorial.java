/*
A recursive method is a method that calls itself.

Recursion is really a more general concept: a recursive definition
is a definition that relies on itself -- the thing is defined in
terms of itself.

0! = 1
1! = 1
2! = 2 * 1 = 2
3! = 3 * 2 * 1 = 6
4! * 4 * 3 * 2 * 1 = 24

Classic definition of factorial:
0! = 1
n! = n * (n - 1) * (n - 2) * .... * 3 * 2 * 1
    (where n is any positive integer)

Examples:
  5! = 5 * 4 * 3 * 2 * 1
     = 120
  4! =     4 * 3 * 2 * 1
     = 24

Notice that 5! = 5 * 4!

Recursive definition of factorial:
0! = 1
n! = n * (n - 1)!
    (where n is any positive integer)

Let's use the recursive definition of factorial
to find 6!:
  6! = 6 * 5!
     = 6 * (5 * 4!)
     = 6 * (5 * (4 * 3!))
     = 6 * (5 * (4 * (3 * 2!)))
     = 6 * (5 * (4 * (3 * (2 * 1!))))
     = 6 * (5 * (4 * (3 * (2 * (1 * 0!)))))
     = 6 * (5 * (4 * (3 * (2 * (1 * 1)))))
     = 6 * (5 * (4 * (3 * (2 * 1))))
     = 6 * (5 * (4 * (3 * 2)))
     = 6 * (5 * (4 * 6))
     = 6 * (5 * 24)
     = 6 * 120
     = 720
*/

void main() {
    IO.println(factorialRecursive(6)); // 720
    IO.println(factorialRecursive(4)); // 24
}

/*
f(4) = 4 * f(3)
     = 4 * 3 * f(2)
     = 4 * 3 * 2 * f(1)
     = 4 * 3 * 2 * 1 * f(0)
     = 4 * 3 * 2 * 1 * 1
     = 24
 */

/*
f(0)    return 1
----------------------------
f(1)    return 1 * __1__ = 1
----------------------------
f(2)    return 2 * __1__ = 2
----------------------------
f(3)    return 3 * __2__ = 6
----------------------------
f(4)    return 4 * __6__  = 24
----------------------------
main
 */

/*
0! = 1
n! = n * (n - 1)!
        (where n is any positive integer)
*/
int factorialRecursive(int n) {
    if (n < 0) {
        throw new IllegalArgumentException(n + " is negative");
    }

    if (n == 0) { // base case
        return 1;
    } else { // recursive case
        return n * factorialRecursive(n - 1);
    }
}

int factorialIterative(int n) {
    int result = 1;

    for (int i = 1; i <= n; i++) {
        result *= i;
    }

    return result;
}

/*
Every problem solved recursively can also be solved iteratively,
and vice versa. Furthermore, a recursive method is usually uses
more memory than an iterative one, due to the many stacks frames
needed to compute the result in a recursive method. So why ever
use recursion? There are some problems that are very difficult
to solve iteratively but can be solved relatively easily with
recursion.
 */