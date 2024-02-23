import java.util.Scanner;
public class PieEatingContest{
   public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);
   
   System.out.println("Pie Eating Constest in the heavyweight division, if you want to participate.");
   System.out.print("Enter your weight here (pounds): ");
   int pounds = scan.nextInt();
   
   if(pounds >= 30 && pounds <= 250)
      System.out.print("You are allowed to join the contest, Goodluck");
   else
      System.out.print("Sorry, You are not allowed to join the contest");
   }
}