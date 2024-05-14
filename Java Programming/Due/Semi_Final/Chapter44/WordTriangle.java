import java.util.Scanner;

public class WordTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String str = scan.nextLine().trim();
        int length = str.length();
        for (int i = 0; i + 1 < str.length(); i++) {
            for (int j = 0; j < i; j++)
                System.out.print(" ");
            if (i < length)
                System.out.println(str.substring(i, length--));
        }
    }
}
