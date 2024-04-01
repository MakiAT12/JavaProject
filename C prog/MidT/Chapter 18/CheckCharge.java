import java.util.Scanner;
public class CheckCharge {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      float serviceCharge = 0;

      System.out.println("Enter the balance of your checking account: ");
      double checkingAcc = scan.nextDouble();
      System.out.println("Enter the balance of your saving account: ");
      double savingAcc = scan.nextDouble();
      if(checkingAcc > 1000 || savingAcc > 1500)
         serviceCharge += 0.15;
      System.out.println("Service Charge is : "+serviceCharge);

   }
}