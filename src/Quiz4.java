import I_stack.ArrayStack264;
import I_stack.Stack264;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class Quiz4 {
    public static boolean allPositive(Node head) {
        if (head == null) {
            return true;
        } else {
            return head.data > 0 && allPositive(head.next);
        }
    }

    public static boolean allPositive(Stack264<Integer> stack) {
        Stack264<Integer> aux = new ArrayStack264<>();
        boolean positiveSoFar = true;

        while (!stack.isEmpty()) {
            int num = stack.pop();
            aux.push(num);

            if (num <= 0) {
                positiveSoFar = false;
            }
        }

        while (!aux.isEmpty()) {
            stack.push(aux.pop());
        }

        return positiveSoFar;
    }
}
