package Due.Final.Chpt67;
import java.io.*;

public class ImageCreator {

    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("image.txt"));
        for (int value = 0; value <= 56; value += 8) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 64; col++) {
                    writer.println(value);
                }
            }
        }
        writer.close();
    }
}
