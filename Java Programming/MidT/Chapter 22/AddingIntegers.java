import java.util.Scanner;
public class  AddingIntegers{
   public static void main (String[] args){
      Scanner scan = new Scanner(System.in);
      int num, sum = 0;
      
      System.out.print("Enter first integer (enter 0 to quit): ");
      num = scan.nextInt();
      if (num != 0) {
         while (num != 0) {
            sum += num;
            System.out.print("Enter first integer (enter 0 to quit): ");
            num = scan.nextInt();
            if (num == 0) 
               System.out.println("Sum of the integers: "+ sum);
         }
      }
      else
         System.out.println("No integers were entered.");
      System.out.println("bye");
   }
}