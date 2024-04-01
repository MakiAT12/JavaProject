import java.util.Scanner;
public class TirePressure {
   public static void main (String[] args) {
      Scanner scan =  new Scanner(System.in);
      
      System.out.println("Input right front pressure");
      byte rightFrontPsi = scan.nextByte();
      System.out.println("Input left front pressure");
      byte leftFrontPsi = scan.nextByte();
      System.out.println("Input right rear pressure");
      byte rightRearPsi = scan.nextByte();
      System.out.println("Input left rear pressure");
      byte leftRearPsi = scan.nextByte();
      if (rightFrontPsi == leftFrontPsi && rightRearPsi == leftRearPsi)
         System.out.println("Inflation is OK");
      else
          System.out.println("\nInflation is not OK");       
   }
}