import java.util.Scanner;
public class UnluckyNumbers {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.println("Input Negative number to exit");
      System.out.print("Enter a number: ");
      long num = input.nextLong();
      
      while (num >= 0) { 
         if (isUnlucky(num)) 
            System.out.println(num + " is unlucky");
         else 
            System.out.println(num + " is safe");   
         
         System.out.print("Enter a number: ");
         num = input.nextLong();
      }
   }
   public static boolean isUnlucky(long n) {      
      for ( ; n != 0 ; n /= 10) {
         boolean has1 = false;
         boolean has3 = false;

         has3 = n % 10 == 3;
            if (has3) {
               n /= 10;
               has1 = n % 10 == 1;
               return has1;
            }
      }
      return false;
   }
}