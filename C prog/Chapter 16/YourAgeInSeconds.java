import java.util.Scanner;            // This Code Inputs a time you have lived in years, months and days to convert it into seconds
 public class YourAgeInSeconds{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Enter years you have lived (ex.2005 to 2024 is 19): ");
      byte year = scan.nextByte(); 
      System.out.print("Enter months you have lived (ex. april is 4): ");
      byte month = scan.nextByte(); 
      System.out.print("Enter days you have lived (ex. current day): ");
      byte day = scan.nextByte();
      
      int totalDay = 365 * year + day;
      if (month >= 1 && month <= 12 && day <= 31 && day >= 1 && year >= 1) {
         if (month > 1)   // January
            totalDay += 31;
         if (month > 2)   // Febuary
            totalDay += 28;   
         if (month > 3)   // March
            totalDay += 31;
         if (month > 4s)   // April
            totalDay += 30;      
         if (month > 5)   // May
            totalDay += 31;
         if (month > 6)   // Jun
            totalDay += 30;
         if (month > 7)   // July
            totalDay += 31;
         if (month > 8)   // August
            totalDay += 31;
         if (month > 9)   // September
            totalDay += 30;
         if (month > 10)  // October
            totalDay += 31;
         if (month > 11)  // November // December is on days
            totalDay += 30;
         
         double percentLifespan = ((totalDay * 24 * 60 * 60) / 2.5e9) * 100.0;
         System.out.println("\nTotal seconds you lived is "+ (totalDay * 24 * 60 * 60)+" seconds");
         System.out.printf("\nThe expected percentage lifespan you will live in seconds is %.1f %%", percentLifespan);
            }        
      else
         System.out.println("Invalid Input");
      
   }
}