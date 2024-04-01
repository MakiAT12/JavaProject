import java.util.Scanner;
public class HarmonicSum {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int i = 1;
      double sum = 0.0;
      
      System.out.println("Enter N (limit of loop)");
      byte limit = scan.nextByte();
      while(i <= limit) {
         sum += 1.0 / i;
         i++;
      }
      System.out.printf("\nSum is: %.11f", sum);
   }
}