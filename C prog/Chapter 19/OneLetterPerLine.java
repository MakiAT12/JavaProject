import java.util.Scanner; // this code loops a word but it only print one character of a word consecutively 
public class OneLetterPerLine {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int i = 1;
      
      System.out.print("Enter a word:");
      String word = scan.nextLine();
      while(i <= word.length()) {
         System.out.print(word.charAt(i - 1)+"\n");
         i++;
      }      
   }
}