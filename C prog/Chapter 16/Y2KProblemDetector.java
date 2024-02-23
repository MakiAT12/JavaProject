import java.util.Scanner;
import java.text.*;
public class Y2KProblemDetector {
   public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);
   
   System.out.print("Year of Birth in two digits(ex. 2005 is 05): ");
   int birthYr = scan.nextInt();
   System.out.print("Current year in two digits(ex. 2024) is 24: ");
   int currentYr = scan.nextInt();
   
   if (currentYr < 100 && birthYr < 100) {
      if(currentYr > birthYr)
         System.out.println("Your age: "+ (currentYr - birthYr));
      else
         System.out.println("Your age: "+ (currentYr + 100 - birthYr));
   }
   else
      System.out.println("Invalid input must use only two digits (ex. 2000 is 00)");
   }
}