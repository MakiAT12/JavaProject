import java.util.Scanner;
public class NameEcho {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;

        System.out.print("Enter your name: ");
        name = scan.nextLine().trim();
        int spaceIndex = name.indexOf(" ");
        String firstName = name.substring(0, spaceIndex);
        String LasttName = name.toUpperCase().substring(spaceIndex + 1);
        name = firstName.concat(" ").concat(LasttName);

        System.out.println(name);
    }
}
    
