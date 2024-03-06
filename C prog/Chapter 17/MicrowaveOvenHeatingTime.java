import java.util.Scanner;
public class MicrowaveOvenHeatingTime {
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      System.out.print("How many items to heat: ");
      byte item = scan.nextByte();
      System.out.print("Time for one item: ");
      int time = scan.nextInt();
      
      if(item > 0 && item <= 3) {
         if(item == 1)
            System.out.println("Heat for "+(time / 100)+" minutes "+(time % 100)+" seconds");
         else if(item == 2)
            System.out.println("Heat for "+(int)((time + (time * .5)) / 100)+" minutes "+(int)((time + (time * .5)) % 100)+" seconds");
         else
            System.out.println("Heat for "+(time * 2 / 100)+" minutes "+(time * 2 % 100)+" seconds");
      }
      else if (item > 3)
         System.out.printf("It is not recommend to hit up %d items in a microwave",item);
      else
         System.out.println("No item to be heated");     
   }
}