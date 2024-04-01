import java.util.Scanner;
public class LastChanceGas{
   public static void main(String[] args){
   Scanner scan = new Scanner(System.in);
   
   System.out.println("Tank capicity (gallon):");
   int tank = scan.nextInt();
   System.out.println("Gage reading (percent):");
   int gage = scan.nextInt();
   System.out.println("Miles per gallon:");
   int miles = scan.nextInt();
   
   int remainingGallons = gage / 100 * tank;
   int maxDistance = remainingGallons * miles;
   
   if (maxDistance >= 200)
      System.out.println("Safe to Proceed");
      System.out.println("Remaining Gas");
      
   else
      System.out.println("Get Gas!");
   

   }
}