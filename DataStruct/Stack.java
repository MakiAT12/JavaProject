public class Stack {
    private String[] arr;
    private int count = 0;
    
    public Stack(int size) {
        arr = new String[size]; // Initialize stack array
    }

    private boolean isEmpty() {
        return count == 0;
    }
    
    private boolean isFull() {
        return count == arr.length;
    }
    
    public boolean push(String str) {
        if (!isFull()) {
            arr[count++] = str;
            return true;
        } else return false;
    }
    
    public boolean pop() {
        if (!isEmpty()) {
            count--;
            return true;
        } else return false;
    }
    
    public String peek() {
        return arr[count - 1];
    }
    private boolean isNum(char c){
        return c >= 0 && c <= 9;
    }
    // Helper method to check if character is an operator
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Helper method to define precedence of operators
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
    
    // Method to convert infix expression to postfix
    public String inToPost(String str) {
        String cut = ""; // This will store the postfix expression
        
        Stack operatorStack = new Stack(str.length()); // Stack for operators
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            // If the character is a digit, add it directly to the result
            if (isNum(c)) {
                cut += c;
            }
            // If the character is an operator, handle it with stack logic
            else if (isOperator(c)) {
                // Pop operators from stack with higher or equal precedence and add to result
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek().charAt(0)) >= precedence(c)) {
                    cut += operatorStack.peek();
                    operatorStack.pop();
                }
                // Push the current operator to the stack
                operatorStack.push(String.valueOf(c));
            }
        }
        
        // Pop all remaining operators from the stack
        while (!operatorStack.isEmpty()) {
            cut += operatorStack.peek();
            operatorStack.pop();
        }
        return cut;
    }
    /*public void clearStack(boolean tf){
        while (!isEmpty() && tf) {
            pop();
        }
    } */
    /*public int calcPost(String str){
        char c;
        for(int i = 0; i < str.length(); i++){
            if(isNum(c))

        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c >= '0' && c <= '9') {
                
            }

        }
    }*/

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        String infix = "3+4*2+2";
        String postfix = stack.inToPost(infix);
        System.out.println("Postfix: " + postfix);  // Expected output: "342*+"
    }
}