import java.util.Scanner; // This code compute the square root of the input that use sentinel loop for the decision of the user to reset or exit the code
public class SqrtCalc {
   public static void main( String[] args ) {
      Scanner scan = new Scanner(System.in );
      String chars; 
      do {
         System.out.print("\nEnter a number-->");
         double x = scan.nextDouble(); 
         scan.nextLine(); // Consume newline character 
         System.out.println("Square root of " + x + " is " + Math.sqrt( x ) );
         do {
            System.out.print("Do you wish to continue? (yes or no) --> ");
            chars = scan.nextLine().toLowerCase();
            if (!chars.equals("yes") &&  !chars.equals("no"))
               System.out.println(">>>Please respond with (yes or no)<<<");
         }
         while (!chars.equals("yes") && !chars.equals("no")); // Continue looping until valid input ("yes" or "no")
      } 
      while (chars.equals( "yes" )); // Continue looping as long as the input is "yes"
      System.out.println("Bye!");
  }
}