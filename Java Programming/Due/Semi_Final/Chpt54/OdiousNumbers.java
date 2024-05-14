import java.util.Scanner;
public class OdiousNumbers {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.println("(To exit, enter a negative value)");
      System.out.print("Enter a number: ");
      long num = input.nextLong();
      
      while (num >= 0) {
         if (isOdious(num))
            System.out.println(num + " is odious");
         else
            System.out.println(num + " is evil");
         System.out.print("Enter a number: ");
         num = input.nextLong();
      }
   }
   public static boolean isOdious(long n) {
      int sum = 0;
      
      for ( ; n != 0 ; n /= 2) 
         sum += n % 2;
      
      return (sum % 2 == 0) ? false : true;
   }
}