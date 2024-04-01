import java.util.Scanner; // this code maximize the spacing using dots between two words with 30 characters 
public class WordsSeparatedByDots {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Enter first word:");
      String wordA = scan.nextLine();
      System.out.println("Enter second word:");
      String wordB = scan.nextLine();
      
      int sumWords = wordA.length() + wordB.length(); 
      System.out.print("\n"+wordA);
      while(sumWords <= 30) {
         System.out.print(".");
         sumWords++;
      }
      System.out.print(wordB);
   }
}