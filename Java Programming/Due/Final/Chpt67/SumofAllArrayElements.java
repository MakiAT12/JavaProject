import java.io.*;

public class SumofAllArrayElements {
  public static void main(String[] args) {
    int[][] data = {
        { 3, 2, 5 },
        { 1, 4, 4, 8, 13 },
        { 9, 1, 0, 2 },
        { 0, 2, 6, 3, -1, -8 }
    };

    // Declare the sum
    int sum = 0;

    // Compute the sum
    for (int row = 0; row < data.length; row++) {
      for (int col = 0; col < data[row].length; col++) {
        sum += data[row][col];
      }
    }

    // Write out the sum
    System.out.println("The sum of all elements is: " + sum);
  }
}