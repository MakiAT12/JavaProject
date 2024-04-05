import java.util.Scanner;
public class GradingSystem {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      byte option;
      float quiz = 0, labwork = 0, exam = 0; // default initialization to access the loop
      final float quizPercentage = 0.2f, labworkPercentage = 0.4f, examPercentage = 0.4f; // fix percentage value
      boolean quizInput = false, labworkInput = false, examInput = false; 
      String word;
      do {
          System.out.println(">>> GRADING SYSTEM <<<");
          System.out.println("[1] Compute Midterm Grade\n[2] Compute Final Grade\n[3] Quit App");
          while (true) {
              System.out.print("Press 1 or 2 or 3: ");
              if (scan.hasNextByte()) {
                  option = scan.nextByte();
                  if (option >= 1 && option <= 3)
                      break;
              }               
              else {
                  System.out.print("(Invalid input) ");
                  scan.next();
              }
          }
          switch (option) {
              case 1: case 2:
                  word = (option == 1 ? "Midterm": "Final");
                  do {
                      System.out.println("\n[Computing "+ word +" Grade]");
                      if (!quizInput) {
                          System.out.print("Enter your Quiz Grade: ");
                          if (scan.hasNextFloat()) {          
                              quiz = scan.nextFloat();
                              quizInput = true;
                          }
                      }
                      if (quizInput && !labworkInput) {
                          System.out.print("Enter your Labwork Grade: ");
                          if (scan.hasNextFloat()) {          
                              labwork = scan.nextFloat();
                              labworkInput = true;
                          }
                      }
                      if(quizInput && labworkInput && !examInput) {
                          System.out.print("Enter your " + word + " Exam Grade: ");
                          if (scan.hasNextFloat()) {          
                              exam = scan.nextFloat();
                              examInput = true;
                          }
                      }
                      if (!quizInput || !labworkInput || !examInput) // take the input of the user and reset it to avoid infinite loop
                          scan.next();
                  } while (!quizInput || !labworkInput || !examInput);// reset the loop if one input is invalid
                  double grade = Math.floor((quiz * quizPercentage + labwork * labworkPercentage + exam *  examPercentage) * 10) / 10; // calculation of the grade
                  System.out.println(word +" Grade : "+grade);
                  System.out.println("Remarks: "+(grade < 4 ? "PASSED!": "FAILED!"));
                  System.out.println();
                  break;
              default:
                  System.out.println("(System Exit)");
                  break;
          }
          quizInput = labworkInput = examInput = false; // return to default on the next literation
      } while (option != 3);
      scan.close();
  }
}