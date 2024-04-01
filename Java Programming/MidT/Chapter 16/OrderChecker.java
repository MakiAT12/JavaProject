import java.util.Scanner;
public class OrderChecker{
   public static void main(String[] args){
   Scanner scan = new Scanner(System.in);
   
   System.out.print("Number of bolts: ");
   int bolts = scan.nextInt();
   System.out.print("Number of nuts: ");
   int nuts = scan.nextInt();
   System.out.print("Number of washers: ");
   int washers = scan.nextInt();
  
   if(nuts >= bolts){
      if (washers >= 2 * bolts)
         System.out.println("\nCheck Order: Order is OK");
      else
         System.out.println("\nCheck Order: too few washers");    
      }
   else if (washers >= 2 * bolts)
      System.out.println("\nCheck Order: too few nuts");
   else
      System.out.println("Check Order:\ttoo few nuts\n\t\t\t\t\ttoo few washers");
   System.out.println("\nTotal cost: "+(3 * nuts + 5 * bolts + washers));
   }
}