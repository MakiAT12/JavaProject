import java.util.Scanner;
import java.lang.Math;
   public class Calculus{
      public static void main(String[] args){
         Scanner scan = new Scanner(System.in);
         
         System.out.print("Enter value of x: ");
         int x = scan.nextInt();
         
         double aprox = Math.pow(1 + 1.0 / x, x);
         System.out.printf("Approximate to e: %.7f", aprox);
      }
   }