import J_queue.ArrayQueue264;
import J_queue.LinkedQueue264;
import J_queue.Queue264;

void main() {
    Queue264<Integer> queue1 = new ArrayQueue264<>(); // or LinkedQueue264
    queue1.enqueue(5);
    queue1.enqueue(10);
    queue1.enqueue(4);
    int result = sum(queue1);
    IO.println(result); // 19
    IO.println(queue1); // [5, 10, 4]

    int[] data = {18, 4, 7, 42, 9, 33, -8, 0, 14, 42, 7, 42, 42, 19};
    Queue264<Integer> queue2 = new LinkedQueue264<>(); // or ArrayQueue3130

    for (int datum : data) {
        queue2.enqueue(datum);
    }

    removeAllOccurrences(queue2, 42);
    IO.println("queue2 = " + queue2); // [18, 4, 7, 9, 33, -8, 0, 14, 7, 19]
}

/*
 Write a method that returns the sum of the elements in the given queue.
 When the method terminates, the queue must be in the same state that it was originally in.
 Constraint: Do not use any auxiliary collections (arrays, ArrayLists, etc.).
*/
int sum(Queue264<Integer> queue) {
    int sum = 0;

    for (int i = 0; i < queue.size(); i++) {
        int element = queue.dequeue();
        sum += element;
        queue.enqueue(element);
    }

    return sum;
}

/*
Write a method that removes all occurrences of the given value in the given queue.
When the method terminates, all other elements should be in the same order that
they were before.
Constraint: Do not use any auxiliary collections (arrays, ArrayLists, etc.).
 */
void removeAllOccurrences(Queue264<Integer> queue, int value) {
    int originalSize = queue.size();

    for (int i = 0; i < originalSize; i++) {
        int element = queue.dequeue();

        if (element != value) {
            queue.enqueue(element);
        }
    }
}
