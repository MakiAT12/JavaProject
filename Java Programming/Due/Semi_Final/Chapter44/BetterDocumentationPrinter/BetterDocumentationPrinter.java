import java.util.Scanner;
public class BetterDocumentationPrinter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;
        boolean insideComment = false;

        while (scan.hasNextLine()) {
            str = scan.nextLine().trim();
            if (!insideComment) {
                if (str.contains("//")) 
                    System.out.println(str.substring(str.indexOf("//")));
                else if (str.contains("/*")) {
                    insideComment = true;
                    System.out.println(str.substring(str.indexOf("/*")));
                }
            } 
            else {
                System.out.println(str.substring(0, str.indexOf("*/")));
                if (str.contains("*/")) 
                    insideComment = false;
            }
        }
    }
}