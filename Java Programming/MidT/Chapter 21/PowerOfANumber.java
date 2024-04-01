import java.util.Scanner;
public class PowerOfANumber {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int i = 1; 
      double powX = 1.0;
      
      System.out.println("Enter X");
      double x = scan.nextDouble();
      System.out.println("Enter N");
      int n = scan.nextInt();
      if(n >= 0) {
         while(i <= n) {
            powX *= x;
            i++;
         }
      }
      else
         System.out.println("N must be a positive integer");
      System.out.println(x +" raised to the power "+n+" is: "+(float)powX);    
   }
}