import java.util.Scanner;
public class ShippingCostCalculator{
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int weight = 1;
      while (weight != 0) {
         double cost = 3.0;
         System.out.println("\nWeight of Order:");
         weight = scan.nextInt();
         if (weight != 0) {
            if (weight > 10)
                 cost += (weight - 10) * 0.25;
            System.out.printf("Shipping Cost: %.2f\n", cost);    
         }        
      }
      System.out.println("\nbye");   
   }
}