import java.util.Scanner; import java.util.Scanner; // This code prompts the user to input a valid file name, providing error handling to guide towards correct input.
public class FilePrompt {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String fileName, name, extension;

      do {
         System.out.print("Input file: ");
         fileName = scanner.nextLine().trim();
         // Split the file name into name and extension parts
         int dotIndex = fileName.lastIndexOf('.');
         if (dotIndex != -1) {
            name = fileName.substring(0, dotIndex);
            extension = fileName.substring(dotIndex);
         } 
         else {
            name = fileName;
            extension = "";
         }
         if (!extension.equals(".dat"))       // Check if the file name meets the requirements
            System.out.println(">>> File name must end with .dat <<<");
         else if (name.contains(" ")) 
            System.out.println(">>> File name must not contain spaces <<<");
         else if (name.isEmpty()) 
            System.out.println(">>> File name missing <<<");
         else {
            System.out.println("OK");
            break; // Exit loop if the file name meets all requirements
         }
      } 
      while (true);
      scanner.close();
    }
}