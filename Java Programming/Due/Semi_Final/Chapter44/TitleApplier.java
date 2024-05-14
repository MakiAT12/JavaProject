import java.util.Scanner;

public class TitleApplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String name;
        do {
            System.out.println("Enter name: ");
            name = scan.nextLine().trim();
            int spaceIndex = name.indexOf(" ");

            if (spaceIndex != -1) { // Check if space exists in the name
                String prefix = name.toLowerCase().substring(0, spaceIndex);
                switch (prefix) {
                    case "heubert": case "elroy": case "fred": case "graham":
                        System.out.print("Mr. ");
                        break; // Add break statement here
                    case "AMY": case "BUFYY": case "CATHY":
                        System.out.print("Ms. ");
                        break; // Add break statement here
                    default:
                        break;      
                }
            }
            System.out.println(name);

        } while (!name.startsWith(name)); // Use name.isEmpty() to check if name is empty
    }
}
