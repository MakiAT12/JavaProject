import java.io.*;

public class SumOfEachColumn {

  public static void main(String[] args) {
    int[][] data = {
        { 3, 2, 5 },
        { 1, 4, 4, 8, 13 },
        { 9, 1, 0, 2 },
        { 0, 2, 6, 3, -1, -8 }
    };

    // Determine the length of the column sums array
    int maxCols = 0;
    for (int row = 0; row < data.length; row++) {
      if (data[row].length > maxCols) {
        maxCols = data[row].length;
      }
    }

    // Create the column sums array
    int[] columnSums = new int[maxCols];

    // Compute the column sums
    for (int row = 0; row < data.length; row++) {
      for (int col = 0; col < data[row].length; col++) {
        columnSums[col] += data[row][col];
      }
    }

    // Print the column sums
    System.out.println("Sum of each column:");
    for (int i = 0; i < maxCols; i++) {
      System.out.println("Column " + i + ": " + columnSums[i]);
    }
  }
}
