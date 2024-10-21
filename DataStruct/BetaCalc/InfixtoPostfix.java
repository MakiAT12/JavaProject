
public class InfixtoPostfix extends StackList{
    private String infix;

    public InfixtoPostfix(String data){
        infix = data;
    }
    private int getPrec(char c){
        if(c == '*' || c == '/')
            return 2;
        if(c == '+' || c == '-')
            return 1;
        return -1;
    }
    public String convert(){
        StackList s = new StackList();
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
}
