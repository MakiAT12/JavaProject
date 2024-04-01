import java.util.Scanner;
public class WedgeOfStars {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int i = 1, row;
      
      System.out.println("Initial number of stars:");
      int numStars = scan.nextByte();
      row = numStars;
      while(i <= row) {
         numStars = row;
         while(i <= numStars) {
            System.out.print("*");
            numStars--; 
         }
         System.out.println();
         i++;
      } 
   }
}