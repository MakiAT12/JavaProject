import java.io.*;

public class MaximumAndMinimumElements {

  public static void main(String[] args) {
    int[][] data = { 
        {3, 2, 5},
        {1, 4, 4, 8, 13},
        {9, 1, 0, 2},
        {0, 2, 6, 3, -1, -8} 
    };
    
    // Initialize max and min
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    
    // Iterate over each element of the array
    for (int row = 0; row < data.length; row++) {
      for (int col = 0; col < data[row].length; col++) {
        // Update max if current element is greater
        if (data[row][col] > max) {
          max = data[row][col];
        }
        // Update min if current element is smaller
        if (data[row][col] < min) {
          min = data[row][col];
        }
      }
    }
      
    // Print the results
    System.out.println("max = " + max + "; min = " + min);
  }
}
