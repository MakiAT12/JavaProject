import java.util.Scanner;
public class DocumentationPrinter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;


        while (scan.hasNextLine()) {
            str = scan.nextLine().trim();
            int point = str.indexOf("//");
            if (str.contains("//"))
                System.out.println(str.substring(point));
        }
    }
}