public class Stack {

    private class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int count;

    public Stack() {
        this.top = null;
        this.count = 0;
    }

    private boolean isEmpty() {
        return top == null;
    }

    public boolean push(String str) {
        Node newNode = new Node(str);
        newNode.next = top;
        top = newNode;
        count++;
        return true;
    }

    public boolean pop() {
        if (!isEmpty()) {
            top = top.next;
            count--;
            return true;
        }
        return false;
    }

    public String peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public String inToPost(String str) {
        String cut = "";
        Stack operatorStack = new Stack();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isNum(c)) {
                cut += c;
            } else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek().charAt(0)) >= precedence(c)) {
                    cut += operatorStack.peek();
                    operatorStack.pop();
                }
                operatorStack.push(String.valueOf(c));
            }
        }

        while (!operatorStack.isEmpty()) {
            cut += operatorStack.peek();
            operatorStack.pop();
        }
        return cut;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        String infix = "3+4*2+2";
        String postfix = stack.inToPost(infix);
        System.out.println("Postfix: " + postfix);
    }
}
