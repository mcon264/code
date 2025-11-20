package I_stack;

/**
 * An unbounded collection of elements to be processed using LIFO order.
 */
public interface Stack264<E> {
    /**
     * Determines whether the stack is empty.
     */
    boolean isEmpty();

    /**
     * Pushes the specified element onto the top of the stack.
     */
    void push(E e);

    /**
     * Pops the top element off the stack and returns it.
     * Throws a NoSuchElementException if the stack is empty.
     */
    E pop();

    /**
     * Returns a String containing the elements listed from top to bottom.
     */
    @Override String toString();
}