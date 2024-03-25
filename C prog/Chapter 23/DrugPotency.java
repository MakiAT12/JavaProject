import java.util.Scanner;
public class DrugPotency {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      double effectiveness = 100.0;
      int month = 0;
      
      System.out.println("Enter a drug loss percentage of its effectiveness:");
      double percent = scan.nextFloat();
      System.out.print("\nMonth: "+ (month++) +" \t\teffectiveness: "+effectiveness);
      while (effectiveness >= 50) {    
            effectiveness -= effectiveness * percent / 100.0;
            System.out.print("\nMonth: "+ (month++) +" \t\teffectiveness: "+effectiveness);
      }
            System.out.print(" DISCARDED");
   } 
}