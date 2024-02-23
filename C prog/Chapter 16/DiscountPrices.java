import java.util.Scanner;
public class DiscountPrices{
   public static void main(String[] args){
   Scanner scan = new Scanner(System.in);
   
   System.out.println("Enter amount of purchases:");
   int cent = scan.nextInt();
   if(cent >= 100)
      System.out.println("Discounted price: "+(int)(cent - (cent * 0.1)));
   else
      System.out.println("Under 100 cents does not have a discount");
   }
}