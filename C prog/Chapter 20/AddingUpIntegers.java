import java.util.Scanner; // this code ask the user how many times to loop and input a integer within that loop and sum it all
public class AddingUpIntegers {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int i = 1, sum = 0;
      
      System.out.println("How many integers will be added:");
      byte limit = scan.nextByte();
      
      while(i <= limit) {
         System.out.println("Enter an integer:");
         int num = scan.nextInt();
         sum += num;
         i++;
      }
      System.out.println("\nThe sum is "+sum);
   }
}