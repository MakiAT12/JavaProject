import java.util.Scanner;
public class WindChillIndex {
   public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);
   
   System.out.print("Enter Wind Speed(mph): ");
   float mph = scan.nextFloat();
   System.out.print("Enter Temperature(fahrenhiet): ");
   float temp = scan.nextFloat(); 
   
   if(mph < 3 || temp > 50)
      System.out.println("Wind Chill: "+ temp);
   else
      System.out.println("Wind Chill: "+ (35.74 + 0.6215 * temp - 35.75 * Math.pow(mph, 0.16) + 0.4275 * temp * Math.pow(mph, 0.16)));
   }
}