import java.io.*;

public class LargestElements {

  public static void main(String[] args) {
    int[][] data = { 
        {3, 2, 5},
        {1, 4, 4, 8, 13},
        {9, 1, 0, 2},
        {0, 2, 6, 3, -1, -8} 
    };
    
    // Iterate over each row of the array
    for (int row = 0; row < data.length; row++) {
      // Initialize maxInRow for the current row
      int maxInRow = Integer.MIN_VALUE;
      
      // Iterate over each element in the current row
      for (int col = 0; col < data[row].length; col++) {
        // Update maxInRow if the current element is greater
        if (data[row][col] > maxInRow) {
          maxInRow = data[row][col];
        }
      }
      
      // Print the largest element in the current row
      System.out.println("Largest element in row " + row + ": " + maxInRow);
    }
  }
}
