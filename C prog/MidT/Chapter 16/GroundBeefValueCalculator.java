import java.util.Scanner;
import java.text.*;
public class GroundBeefValueCalculator{
   public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);
   DecimalFormat round = new DecimalFormat("0.000000");
   
   System.out.println("Price per pound package A:");
   float poundA = scan.nextFloat();
   System.out.println("Percent lean package A:");
   float percentA = scan.nextFloat();
   System.out.println("Price per pound package B:");
   float poundB = scan.nextFloat();
   System.out.println("Percent lean package B:");
   float percentB = scan.nextFloat();
   
   float costPerPoundA = poundA / (percentA / 100);
   float costPerPoundB = poundB / (percentB / 100);
   System.out.println("\nPackage A cost per pound of lean: "+ Float.parseFloat((round.format(costPerPoundA))));
   System.out.println("Package B cost per pound of lean: "+ Float.parseFloat((round.format(costPerPoundB))));
   if(costPerPoundA < costPerPoundB)
      System.out.println("Package A is the best Value");
   else if (costPerPoundB < costPerPoundA)
      System.out.println("Package B is the best Value");
   else
      System.out.println("Package A and B has the same value");
   }
}