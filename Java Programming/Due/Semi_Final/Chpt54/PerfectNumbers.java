import java.util.Scanner;
public class PerfectNumbers {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter a number: ");
      int num = input.nextInt();
      
      if (isPerfectNum(num))
         System.out.println(num + " is a Perfect Number");
      else
         System.out.println(num + " is not a Perfect Number");
   }
   public static boolean isPerfectNum(int n) {
      int sum = 0;
 
      for (int num = 1 ; num < n ; num++) {
         if (n % num == 0) 
            sum += num; 
      }
       
      if (n == sum)
         return true;
      else
         return false;
   }
}