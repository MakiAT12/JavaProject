import java.util.Scanner;
public class AddingUpSquaresAndCubes {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);
      int i = 1, sumSqr = 0, sumCube = 0;
      
      System.out.println("Upper Limit:");
      int n = scan.nextInt();
      while(i <= n) {
         sumSqr += Math.pow(i, 2);
         sumCube += Math.pow(i, 3);
         i++;
      }
      System.out.println("The sum of Squares in loops is "+sumSqr);
      System.out.println("The sum of Cubes in loops is "+sumCube);
      
      sumSqr = n * (n + 1) * (2 * n + 1) / 6;
      sumCube = (int) (Math.pow(n, 2) * Math.pow(n + 1, 2) / 4);
      System.out.println("\nSum of squars using formula: "+sumSqr);
      System.out.println("Sum of cubes using formula: "+sumCube);
      
   }
}