import I_stack.PostfixEvaluator;

void main() {
    PostfixEvaluator evaluator = new PostfixEvaluator();
    String expression = IO.readln("postfix expression: ");

    while (!expression.isEmpty()) {
        try {
            int result = evaluator.evaluate(expression);
            IO.println("result: " + result);
        } catch (Exception e) {
            IO.println("invalid");
        }

        expression = IO.readln("postfix expression: ");
    }
}