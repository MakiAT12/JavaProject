import java.util.Scanner; // This code counts the characters within the line by sorting which type of character it is and compute the percentage of each type of all characters
public class CharacterCounterWithFileInput {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int totalConsonants = 0, totalVowels = 0, totalPunctuation = 0, totalSpaces = 0;
      int lineCount = 0;

      while (true) {
         System.out.print("Enter a line (or type 'quit' to exit): ");
         String line = scanner.nextLine();
         if (line.equals("quit")) {
            break;
         }
         lineCount++;
         int consonants = 0, vowels = 0, punctuation = 0, spaces = 0;
         line = line.toLowerCase(); // Convert to lowercase for simplicity
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
         totalConsonants += consonants;
         totalVowels += vowels;
         totalPunctuation += punctuation;
         totalSpaces += spaces;
      }
      int totalCount = totalConsonants + totalVowels + totalPunctuation + totalSpaces;
      double consonantPercentage = (double) totalConsonants / totalCount * 100;
      double vowelPercentage = (double) totalVowels / totalCount * 100;
      double punctuationPercentage = (double) totalPunctuation / totalCount * 100;
      double spacePercentage = (double) totalSpaces / totalCount * 100;
      System.out.println("\nRaw Counts:");
      System.out.println("Total Consonants: " + totalConsonants);
      System.out.println("Total Vowels: " + totalVowels);
      System.out.println("Total Punctuation: " + totalPunctuation);
      System.out.println("Total Spaces: " + totalSpaces);
      System.out.println("\nPercentages:");
      System.out.println("Consonants: " + consonantPercentage + "%");
      System.out.println("Vowels: " + vowelPercentage + "%");
      System.out.println("Punctuation: " + punctuationPercentage + "%");
      System.out.println("Spaces: " + spacePercentage + "%");
      scanner.close();
   }
}