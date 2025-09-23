import java.io.*;
import java.util.StringTokenizer;

public class Memory {
    private String[] mem;
    private int size = 100;

    public Memory(int size) {
        this.size = size;
        mem = new String[size];
    }

    public Memory(String[] data) {
        this.size = data.length;
        this.mem = new String[size];
        System.arraycopy(data, 0, mem, 0, size);
    }

    public void additem(int address, String data){
        int num = Integer.parseInt(data);
        this.mem[address] = String.format("%04d", num);
    }
    public String getitem(int address){
        return this.mem[address];
    }

    public void dump() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.print("    ");
        for (int col = 0; col < 10; col++) {
            System.out.printf("  %-8d", col);
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            if (i % 10 == 0) {
                if (i != 0) System.out.println();
                System.out.printf("%02d  ", i);
            }
            System.out.printf("%-10s", mem[i] != null ? "+" + mem[i] : "+0000");
        }

        System.out.println();
    }

    public void MemoryLoader(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                //disregard description
                if (line.contains(";")) {
                    line = line.substring(0, line.indexOf(";")).trim();
                }

                if (line.isEmpty()) continue;

                // tokenizer getting address and value
                StringTokenizer tokenizer = new StringTokenizer(line);
                if (tokenizer.countTokens() < 2) continue; 

                int address = Integer.parseInt(tokenizer.nextToken());
                String value = tokenizer.nextToken();

                if (address >= 0 && address < size) {
                    int num = Integer.parseInt(value);
                    mem[address] = String.format("%04d", num);
                } else {
                    System.out.println("No memory address found " + address);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Memory memory = new Memory(100);
        memory.MemoryLoader("test.txt"); 
        memory.dump();
    }
}