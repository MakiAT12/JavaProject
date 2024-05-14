import java.util.Scanner;

public class UnluckyEvilNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the upper limit: ");
        long upperLimit = input.nextLong();

        for (long i = 1; i <= upperLimit; i++) {
            if (isUnlucky(i) && !isOdious(i)) {
                System.out.println(i + " is both unlucky and evil");
            } 
            else
                System.out.println("No unlucky numbers");
        }
    }
    // Method to check if a number is unlucky
    public static boolean isUnlucky(long n) {
        for (; n != 0; n /= 10) {
            boolean has1 = false;
            boolean has3 = false;

            has3 = n % 10 == 3;
            if (has3) {
                n /= 10;
                has1 = n % 10 == 1;
                return has1;
            }
        }
        return false;
    }
    // Method to check if a number is odious
    public static boolean isOdious(long n) {
        int sum = 0;

        for (; n != 0; n /= 2)
            sum += n % 2;

        return (sum % 2 != 0);
    }
}