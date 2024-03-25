import java.util.Scanner;
public class MilesPerGallon{
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int initialMiles = 0;
      double milesPerG;
      
      while (initialMiles  >= 0) {
         System.out.println("Initial miles:");
         initialMiles = scan.nextInt();
         if (initialMiles  >= 0) {
            System.out.println("Final miles:");
            int finalMiles = scan.nextInt();
            System.out.println("Gallons");
            int gallons = scan.nextInt();
            milesPerG = (finalMiles - initialMiles) / gallons;
            System.out.println("Miles per Gallon: "+milesPerG+"\n");
         }
         else
            System.out.println("bye");
      }
   }
}