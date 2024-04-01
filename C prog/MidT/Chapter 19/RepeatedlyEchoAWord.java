import java.util.Scanner; // this code loops a word depending the number of characters of that word 
public class RepeatedlyEchoAWord {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int i = 1;
      
      System.out.println("Enter a word:");
      String word = scan.nextLine();
      while(i <= word.length()) {
         System.out.print("\n"+word);
         i++;
      }      
   }
}