import java.util.Scanner;
public class GradingSystem {
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      final float quizPercentage = 0.2f, labworkPercentage = 0.4f, examPercentage = 0.4f;
      byte option = 4;
      String word;
      
      System.out.println("[GRADING SYSTEM COMPUTER]");
      while (option != 3) {
         System.out.println("\n[1] Compute Midterm Grade\n[2] Compute Final Grade\n[3] Quit App");
         option = 4;
         while (option < 1 || option > 3) {
            System.out.print("Press 1 or 2 or 3: ");   
            option = scan.nextByte();
            if (option >=  1 && option <= 3) {
               if (option <= 2) {
                  System.out.print("\nEnter your Quiz Grade: ");
                  float quiz = scan.nextFloat();
                  System.out.print("Enter your Labwork Grade: ");
                  float labwork = scan.nextFloat();
                  if (option == 1)
                     word = "Midterm"; 
                  else 
                     word = "Final";
                  System.out.print("Enter your "+word+" Exam Grade : ");  
                  float exam = scan.nextFloat();
                  double grade = Math.floor((quiz * quizPercentage + labwork * labworkPercentage + exam *  examPercentage) * 10) / 10;
                  System.out.println(word+" Grade : "+grade);
                  if (grade <= 3)
                     word = "PASSED";
                  else
                     word = "FAILED";
                  System.out.println("Remarks: "+word);
               }                    
               else
                  System.out.println("(System Exit)");
            }             
            else {
               System.out.print("(Invalid input) ");
               option = 4;
            }      
         }
      }
   }
}