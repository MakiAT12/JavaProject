import java.util.Scanner;
public class MoreTirePressure {
   public static void main (String[] args) {
      Scanner scan =  new Scanner(System.in);
      boolean goodPressure = true; // default value
      
      System.out.println("Input right front pressure");
      byte rightFrontPsi = scan.nextByte();
      if(rightFrontPsi < 35 || rightFrontPsi > 45) {
         System.out.println("Warning: pressure is out of range\n");
         goodPressure = false;
      }
      System.out.println("Input left front pressure");
      byte leftFrontPsi = scan.nextByte();
      if(leftFrontPsi < 35 || leftFrontPsi > 45) {
         System.out.println("Warning: pressure is out of range\n");
         goodPressure = false;
      }
      System.out.println("Input right rear pressure");
      byte rightRearPsi = scan.nextByte();
      if(rightRearPsi < 35 || rightRearPsi > 45) {
         System.out.println("Warning: pressure is out of range\n");
         goodPressure = false;
      }
      System.out.println("Input left rear pressure");
      byte leftRearPsi = scan.nextByte();
      if(leftRearPsi < 35 || leftRearPsi > 45 ){
         System.out.println("Warning: pressure is out of range\n");
         goodPressure = false;
      }
      
      if (rightFrontPsi == leftFrontPsi && rightRearPsi == leftRearPsi && goodPressure)
         System.out.println("Inflation is OK");
      else if (goodPressure)
          System.out.println("\nInflation is not OK");
      else
         System.out.println("\nInflation is BAD");
   }
}