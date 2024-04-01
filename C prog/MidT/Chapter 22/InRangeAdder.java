import java.util.Scanner;
public class InRangeAdder{
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int data = 1, inSum = 0, outSum = 0;
       
      System.out.println("In-range Adder");
      System.out.println("Low end of range:");
      int lowRange = scan.nextInt(); 
      System.out.println("High end of range:");
      int highRange = scan.nextInt();
      while (data != 0) {
         System.out.println("Enter data:");
         data = scan.nextInt(); 
         if (data >= lowRange && data <= highRange)
            inSum += data;
         else
            outSum += data;
      }
      System.out.println("Sum of in range values: "+inSum);
      System.out.println("Sum of out of range values: "+outSum);
   }
}