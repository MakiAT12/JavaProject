import java.util.Scanner;

public class InfixToPostfix{
    static String infix;

    public InfixToPostfix(String data){
        infix = data;

    }
    private static int getPrec(char c){
        if(c == '*' || c == '/')
            return 2;
        if(c == '+' || c == '-')
            return 1;
        return -1;
    }
    public  String convert(){
        StackNode s = new StackNode();
        String result =  "";

        for(int i = 0; i < infix.length(); i++){
            char c = infix.charAt(i);

            if(Character.isDigit(c))
                result += c;
            else if (c == '(')
                s.push(c+"");
            else if(c == ')'){
                while(!s.peek().equals("("))
                    result += s.pop();
                s.pop();
            }
            else {
                while (!s.isEmpty() && getPrec(c) <= getPrec(s.peek().charAt(0))) {
                    result += s.pop();
                }
                s.push(c + "");
            }
        }
        while (!s.isEmpty()) {
            result += s.pop()+"";
        }
        return result;
    }
    public  double evaluate (String r){
        StackNode s =  new StackNode();
        double ans = 0;
        for(int i = 0; i < r.length(); i++){
            char ch = r.charAt(i);

            if(Character.isDigit(ch))
                s.push(ch+"");
            else{
                double val2 = Double.parseDouble(s.pop());
                double val1 = Double.parseDouble(s.pop());

                switch(ch){
                    case '*':
                        ans = val1 * val2;
                        break;
                    case '/':
                        ans = val1 / val2;
                        break;
                    case '+':
                        ans = val1 + val2;
                        break;
                    case '-':
                        ans = val1 - val2;
                        break;
                }
                s.push(ans + "");
            }
        }
        return Double.parseDouble(s.pop());
    }
}
 class StackNode {
    Scanner scan = new Scanner(System.in);
    private Node top;
    private int count;
    public StackNode() {
        top = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean push(String data) {
        Node node = new Node(data);
        node.tail = top;
        top = node;
        count++;
        return true;
    }

    public String pop() {
        if (!isEmpty()) {
            String data= top.data;
            top = top.tail;
            count--;
            return data;
        }
        return null;
    }

    public String peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public void display() {
        if (!isEmpty()) {
            Node temporary = top;
            while (temporary != null) {
                System.out.println(temporary.data);
                temporary = temporary.tail;
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty....");
        }
    }
}