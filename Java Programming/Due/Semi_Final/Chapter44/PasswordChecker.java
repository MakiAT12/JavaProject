import java.util.Scanner;
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean option1, option2, option3;

        do {
            System.out.print("Enter password: ");
            String pass = scan.nextLine().trim();
            option1 = option2 = option3 = true;

            if (pass.length() >= 7) {
                for (int i = 0; i < pass.length(); i++) {
                    char ch = pass.charAt(i);
                    if (ch >= 97 && ch <= 122)
                        option1 = false;
                    if (ch >= 65 && ch <= 90)
                        option2 = false;
                    if (ch >= 48 && ch <= 57)
                        option3 = false;
                }
            }
            if (option1 || option2 || option3) 
                System.out.println("Password must contain at least 7 characters, including uppercase, lowercase, digit and no symbols.\n");
        } while (option1 || option2 || option3);
        System.out.println("Password is valid.");
    }
}