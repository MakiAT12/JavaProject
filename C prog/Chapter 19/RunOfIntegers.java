import java.util.Scanner; // this code use controlled loop when the user inputs the starting and ending numebrs
public class RunOfIntegers {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Enter Start:"); // starting loop
      int start = scan.nextInt();
      System.out.println("Enter End:"); // max loop
      int end = scan.nextInt();
      
      while(start <= end) {
         System.out.print("\n"+start);
         start++;
      }   
   }
}