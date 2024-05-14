import java.util.Scanner; 
public class FactorialWithErrorFlag {  
   public static void main(String[] args)  {   
         Scanner scan = new Scanner(System.in); 
         
         System.out.print("Enter number: ");    
         int num = scan.nextInt();
         long fact = computeFactorial(num);
         
         if (fact >= 0 ) 
            System.out.println("Factorial of " + num + " is " + fact);
         else  
            System.out.println("Number should be non-negative.");  
   }
   public static long computeFactorial(int num) {
       if (num < 0 || num > 20)  
            return -1;  
       else  {  
            int fact = num;  
            
            for (int a = (num - 1) ; a > 1 ; a--)  
                  fact = fact * a;  
            
            return fact;  
        }  
   }
}