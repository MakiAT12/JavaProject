import java.io.*;

public class ReversalOfElementsInEachRow {
  static int[][] data = { 
    {3, 2, 5},
    {1, 4, 4, 8, 13},
    {9, 1, 0, 2},
    {0, 2, 6, 3, -1, 8},
    {-1, -2, -3, 4, 5, 45},
    {56},
    {0, 1, 2, 3, 4, 5, 6, 7}
  };

  private static void printArray() {
    for (int row = 0; row < data.length; row++) {
      for (int col = 0; col < data[row].length - 1; col++) {
        System.out.print(data[row][col] + ", ");
      }
      System.out.println(data[row][data[row].length - 1]);
    }
  }

  public static void main(String[] args) {
    // print out the initial array
    System.out.println("Original Matrix:");
    printArray();
    System.out.println();

    // reverse each row
    for (int row = 0; row < data.length; row++) {
      int endIdx = data[row].length - 1;
      for (int col = 0; col < data[row].length / 2; col++) {
        // Swap elements at col and endIdx
        int temp = data[row][col];
        data[row][col] = data[row][endIdx];
        data[row][endIdx] = temp;
        // Move towards the middle
        endIdx--;
      }
    }

    // print out the reversed array
    System.out.println("Reversed Matrix:");
    printArray();
  }
}
