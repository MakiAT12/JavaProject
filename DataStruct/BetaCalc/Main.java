public class Main{
   public static void main(String... arhs){
      InfixtoPostfix to = new InfixtoPostfix("(1+6)*2");
      
      String result = to.convert();
      System.out.println(result);
      
      double ans = evaluate(result);
      
      System.out.println("Result: "+ ans);
   }
   public static double evaluate (String r){
      StackList s =  new StackList();
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