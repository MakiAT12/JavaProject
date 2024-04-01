import java.util.Scanner; // this code computes a sum of the loop within the users input integers start to end
public class SumOfARangeOfSequentialInteger {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int sum = 0;
      
      System.out.println("Enter low:");
      int low = scan.nextInt();
      System.out.println("Enter high:");
      int high = scan.nextInt();
      while (low <= high) {
         sum += low;
         low++;
      }
      System.out.println("Sum = "+sum);
   }
}