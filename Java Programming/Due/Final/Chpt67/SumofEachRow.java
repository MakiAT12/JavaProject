import java.io.*;

public class SumofEachRow {

  public static void main(String[] args) {
    int[][] data = { 
        {3, 2, 5},
        {1, 4, 4, 8, 13},
        {9, 1, 0, 2},
        {0, 2, 6, 3, -1, -8} 
    };
    
    // Compute the sums for each row
    for (int row = 0; row < data.length; row++) {
      // Declare and initialize the sum for the current row
      int rowSum = 0;
      
      // Compute the sum for this row
      for (int col = 0; col < data[row].length; col++) {
        rowSum += data[row][col];
      }
      
      // Write the sum for this row
      System.out.println("Sum of elements in row " + row + ": " + rowSum);
    }
  }
}
