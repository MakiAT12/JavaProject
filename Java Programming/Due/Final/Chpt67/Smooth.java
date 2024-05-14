import java.io.*;

public class Smooth {

    public static void main(String[] args) {
        int[][] image = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0},
            {0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0},
            {0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0},
            {0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0},
            {0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0},
            {0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0},
            {0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0},
            {0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // assume a rectangular image
        int[][] smooth = new int[image.length][image[0].length];

        // Compute the smoothed value for 
        // non-edge locations in the image.
        for (int row = 1; row < image.length - 1; row++) {
            for (int col = 1; col < image[row].length - 1; col++) {
                int sum = 0;
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        sum += image[i][j];
                    }
                }
                smooth[row][col] = sum / 9;
            }
        }

        // Write out the input
        System.out.println("Original Image:");
        printArray(image);

        // Write out the result
        System.out.println("\nSmoothed Image:");
        printArray(smooth);
    }

    // Helper method to print a 2D array
    private static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}