import java.util.Scanner;

public class ChartAt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String str = scan.nextLine().trim();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.print("\n"+ c);
        }           
    }
}