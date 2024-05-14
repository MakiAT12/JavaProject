package Due.Final.Chpt67;
import java.io.*;

public class ImageDisplay {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("image.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            int value = Integer.parseInt(line);
            char displayChar;
            switch (value / 8) {
                case 0:
                    displayChar = ' ';
                    break;
                case 1:
                    displayChar = '.';
                    break;
                case 2:
                    displayChar = ',';
                    break;
                case 3:
                    displayChar = '-';
                    break;
                case 4:
                    displayChar = '+';
                    break;
                case 5:
                    displayChar = 'o';
                    break;
                case 6:
                    displayChar = 'O';
                    break;
                default:
                    displayChar = 'X';
            }
            System.out.print(displayChar);
            if (value % 64 == 63) {
                System.out.println();
            }
        }
        reader.close();
    }
}
