import java.util.Scanner; // this code computes a sum of the loop and the formula
public class SumOfSequentialIntegers {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int i = 1, sum, j = 0;
      
      System.out.println("Enter N:"); // starting loop
      int n = scan.nextInt();
     
      while(i <= n) {
         j += i;
         i++;
      }   
      sum = (n *(n + 1)) / 2;
      System.out.println("Loop Sum = "+j);  
      System.out.println("Formula Sum = "+sum);   
   }
}