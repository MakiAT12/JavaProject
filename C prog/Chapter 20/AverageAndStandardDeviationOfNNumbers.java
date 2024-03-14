import java.util.Scanner;
public class AverageAndStandardDeviationOfNNumbers {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int i = 1;
      double sumX = 0.0, sumXPow = 0.0, avgPow, avgSqr, sd;
      
      System.out.print("Enter Number of values: ");
      byte limit = scan.nextByte();
      while(i <= limit) {
         System.out.println("Enter the data value of X"+i+":");
         float num = scan.nextFloat();
         sumX += num;
         sumXPow += Math.pow(num, 2);
         i++;
      }
      avgPow = Math.pow((sumX / limit), 2);
      avgSqr = sumXPow / limit;
      sd = Math.sqrt(avgSqr - avgPow);
      System.out.println("\nThe Average is: "+(avgSqr - avgPow));
      System.out.printf("Standard Deviation is: %.10f",sd);
   }
}