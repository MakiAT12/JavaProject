//This program asks the user for N and R and writes out NCR
/* Uses the error-flagging version of factorial in exercise 5 and report an error 
   if a factorial can't be computed */
import java.util.Scanner;
public class Combinations {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter N: ");
    int n = scanner.nextInt();

    System.out.print("Enter R: ");
    int r = scanner.nextInt();

    if (n >= r) {
      long ncr = fact(n) / (fact(r) * fact(n - r));
      System.out.println("nCr = " + ncr);
    }
    else
      System.out.println("Error: R is too large.");
  }
  //This means that N cannot be larger than 20, which is a severe restriction
  public static long fact(int num) {
    if (num < 0)
      throw new IllegalArgumentException("Number must be non-negative!");
    if (num > 20)
      throw new IllegalArgumentException("Number must be smaller than 21!");
    
    long result = 1;
    for (int x = 1 ; x <= num ; x++)
      result *= x;

    return result;
  }
}