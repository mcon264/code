package K_deque;

import I_stack.Stack264;
import J_queue.Queue264;

public interface Deque264<E> extends Stack264<E>, Queue264<E> {
    void addFirst(E e);
    void addLast(E e);
    E getFirst();
    E getLast();
    E removeFirst();
    E removeLast();

    // Stack264 methods

    @Override
    default void push(E e) {
        addFirst(e);
    }

    @Override
    default E pop() {
        return removeFirst();
    }

    // Queue264 methods

    @Override
    default void enqueue(E e) {
        addLast(e);
    }

    @Override
    default E dequeue() {
        return removeFirst();
    }

    @Override
    default E peek() {
        return getFirst();
    }
}