import java.util.Scanner;
class ABC{
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Input Number (0 - 35): ");
      byte num = scan.nextByte();
      
      if(num >= 0 && num <= 35){
         if (num < 10)
            System.out.println(num);
         else
            System.out.println((char)(num+55)+" is "+num);
      }
      else
         System.out.println("Invalid Input, Only (0 - 35)");
   }
}