import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    private final String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }

    // Existing loader (for compiled machine code)
    // public void loadProgram(Memory memory) {
    //     try (Scanner fileScanner = new Scanner(new File(filename))) {
    //         while (fileScanner.hasNextLine()) {
    //             String line = fileScanner.nextLine().trim();

    //             // Skip empty lines or comments
    //             if (line.isEmpty() || line.startsWith(";")) continue;

    //             String[] parts = line.split("\\s+");
    //             if (parts.length < 2) continue;

    //             int address = Integer.parseInt(parts[0]);
    //             String instruction = String.format("%04d", Integer.parseInt(parts[1]));

    //             memory.additem(address, instruction);
    //         }
    //     } catch (Exception e) {
    //         System.out.println("Error loading program: " + e.getMessage());
    //     }
    // }

    //  method for the compiler to read plain text source code
    public List<String> readSourceLines() {
        List<String> sourceLines = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Remove comments
                if (line.contains(";"))
                    line = line.substring(0, line.indexOf(";"));

                line = line.trim();
                if (!line.isEmpty()) {
                    sourceLines.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + filename);
        }

        return sourceLines;
    }
}
