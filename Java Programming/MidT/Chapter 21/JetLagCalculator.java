import java.util.Scanner;
public class JetLagCalculator {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int departureTime = 0, arrivalTime = 0;
      double recoveryDays;
      boolean error = true;
      
      System.out.print("Enter number of hours of travel: ");
      byte travelHrs = scan.nextByte(); 
      System.out.print("Enter number of time zones crossed: ");
      byte zoneCross = scan.nextByte();
      System.out.print("Enter departure time in 24hour clock [ex. 1:30am is 130; 5:30pm is 1330]\n: "); 
      while (error) {
         departureTime = scan.nextInt();
         error = false;
         if(departureTime >= 1 && departureTime <= 24)
            departureTime *= 100;
         if(departureTime >= 800 && departureTime < 1200)
            departureTime = 1;
         else if(departureTime >= 1200 && departureTime < 1400)
            departureTime = 2;
         else if(departureTime >= 1400 && departureTime < 1800)
            departureTime = 3;
         else if(departureTime >= 1800 && departureTime <= 2459)
            departureTime = 4;
         else if(departureTime >= 100 && departureTime < 800)
            departureTime = 5;
         else{
            System.out.print("Invalid departure time input, must be [ex. 1:30am is 130; 5:30pm is 1330]\nTry again: ");
            error = true;  
         }
      }
      System.out.print("Enter arrival time in 24hour clock [ex. 1:30am is 130; 5:30pm is 1330]\n: ");
      error = true;
      while (error) {
         arrivalTime = scan.nextInt();
         error = false;
         if(arrivalTime >= 1 && arrivalTime <= 24)
            arrivalTime *= 100;
         if(arrivalTime >= 800 && arrivalTime < 1200)
            arrivalTime = 4;
         else if(arrivalTime >= 1200 && arrivalTime < 1400)
            arrivalTime = 2;
         else if(arrivalTime >= 1400 && arrivalTime < 1800)
            arrivalTime = 0;
         else if(arrivalTime >= 1800 && arrivalTime <= 2459)
            arrivalTime = 1;
         else if(arrivalTime >= 100 && arrivalTime < 800)
            arrivalTime = 3;
         else{
            System.out.print("Invalid arrival time input, must be [ex. 1:30am is 130; 5:30pm is 1330]\nTry again: ");
            error = true;
         }        
      }
      recoveryDays = (travelHrs/2.0 + (zoneCross - 3) + departureTime + arrivalTime) / 10.0;
      System.out.println("The days of recovery is "+ recoveryDays+" days");
   }
}