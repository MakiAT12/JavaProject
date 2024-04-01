import java.util.Scanner; // This code counts the character depending on the type of character of the line  
public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int consonants = 0, vowels = 0, punctuation = 0, spaces = 0;
          
        System.out.print("Enter a line: ");
        String line = scanner.nextLine().toLowerCase();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            switch (ch) {
                case 'a': case 'e': case 'i': case 'o': case 'u': //  Check for vowels
                    vowels++;
                    break;
                case 'b': case 'c': case 'd': case 'f': case 'g': case 'h':
                case 'j': case 'k': case 'l': case 'm': case 'n': case 'p': // Check for consonants
                case 'q': case 'r': case 's': case 't': case 'v': case 'w':
                case 'x': case 'y': case 'z':
                    consonants++;
                    break;
                case ' ': // Check for spaces
                    spaces++;
                    break;
                default: // All other characters are considered punctuation
                    punctuation++;
            }
        }
        System.out.println("Consonants: "+consonants+"  Vowels: "+vowels+"  Punctuation: "+punctuation+"  Spaces: "+spaces);
        scanner.close();
    }
}
