import java.util.Scanner;

public class MicrowaveMenu {
   public static void main(String[] args) {
      String time, sec = "00", min = "00";
       
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter cook time-> ");    
      time = input.nextLine().trim();
      
      if (time.length() == 1) 
         sec = "0" + time;
      else if (time.length() == 2) 
         sec = time;
      else if (time.length() == 3) {
         sec = time.substring(1);
         min = "0" + time.charAt(0);
      }
      else if (time.length() == 4) {
         sec = time.substring(2);
         min = time.substring(0,2);
      }
      else
         System.out.println("Exceeded the required digits!");
      
      System.out.println("Your time-> " + min + ":" + sec);
   }
}