import java.util.Scanner;
import java.util.Random;
public class MultiplicationQuiz {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      Random rng = new Random();
      int i = 1, score = 0, numA, numB;
      
      while (i <= 10) {
         numA = 1 + rng.nextInt(9);
         numB = 1 + rng.nextInt(9);
         System.out.print("\n"+i+". What is "+numA+" * "+numB+"?  ");
         int answer = scan.nextInt();
         
         if (numA * numB == answer) {
            System.out.println("Right!");
            score += 1;
         }   
         else
            System.out.println("wrong.  "+numA+" * "+numB+" is "+ (numA * numB));
         i++;
      }
      System.out.print("\nYou got "+score+" out of 10 questions correct!");
   }
}