import I_stack.ArrayStack264;
import I_stack.LinkedStack264;
import I_stack.Stack264;

void main() {
    Stack264<Integer> stack = new ArrayStack264<>();
    // or: Stack264<Integer> stack = new LinkedStack264<>();
    stack.push(10);
    stack.push(5);
    stack.push(15);
    stack.push(12);
    IO.println(stack); // [12, 15, 5, 10]

    IO.println(stack.pop()); // 12
    IO.println(stack.pop()); // 15
    IO.println(stack); // [5, 10]

    stack.push(3);
    stack.push(7);
    IO.println(stack); // [7, 3, 5, 10]

    IO.println(sum(stack)); // 25
    IO.println(stack); // [7, 3, 5, 10]

    while (!stack.isEmpty()) {
        IO.print(stack.pop() + " ");
    }
    // 7 3 5 10
}

/*
Puzzle

Write a method that is given a stack of integers
and returns the sum of the stack's elements.

When the method terminates, the stack must
be in the same state that it was originally in.

Do not use any auxiliary collections (arrays,
ArrayLists, etc.) except for a single stack.
 */
int sum(Stack264<Integer> stack) {
    Stack264<Integer> aux = new ArrayStack264<>();
    int total = 0;

    while (!stack.isEmpty()) {
        int element = stack.pop();
        total += element;
        aux.push(element);
    }

    while (!aux.isEmpty()) {
        stack.push(aux.pop());
    }

    return total;
}