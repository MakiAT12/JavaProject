import java.io.*;
import java.util.*;

public class CompilerProgram {
    private static final Map<String, String> OPCODES = new HashMap<>();
    static {
        OPCODES.put("read", "10");
        OPCODES.put("write", "11");

        OPCODES.put("loadm", "20");
        OPCODES.put("store", "21");
        OPCODES.put("loadi", "22");

        OPCODES.put("addm", "30");
        OPCODES.put("subm", "31");
        OPCODES.put("divm", "32");
        OPCODES.put("modm", "33");
        OPCODES.put("mulm", "34");

        OPCODES.put("addi", "35");
        OPCODES.put("subi", "36");
        OPCODES.put("divi", "37");
        OPCODES.put("modi", "38");
        OPCODES.put("muli", "39");

        OPCODES.put("jmp", "40");
        OPCODES.put("jn", "41");
        OPCODES.put("jz", "42");
        OPCODES.put("halt", "43");
    }

    private final Memory memory;
    private final Map<String, Integer> labelTable = new HashMap<>();
    private final Map<String, Integer> variableTable = new HashMap<>();
    private List<String> sourceLines = new ArrayList<>();
    private int nextVarAddress = 99; // memory size fixed at 100
    private final Set<String> jumpOps = Set.of("jmp", "jn", "jz");

    public CompilerProgram(Memory memory) {
        this.memory = memory;
    }

    public void compile(String filename) {
        sourceLines = readSourceFile(filename);

        // 1st pass: build label table and declared variables
        int address = 0;
        for (String line : sourceLines) {
            line = preprocessLine(line);
            if (line.isEmpty()) continue;

            if (line.endsWith(":")) {
                String label = line.substring(0, line.length() - 1).trim();
                labelTable.put(label, address);
            } else if (!line.contains(" ")) {
                // declared variable
                if (!variableTable.containsKey(line)) {
                    variableTable.put(line, address);
                    memory.additem(address, "0000");
                    address++;
                }
            } else {
                address++;
            }
        }

        // 2nd pass: generate machine code
        address = 0;
        for (String line : sourceLines) {
            line = preprocessLine(line);
            if (line.isEmpty() || line.endsWith(":")) continue;

            String[] parts = line.split("\\s+");
            if (parts.length == 1 && parts[0].equalsIgnoreCase("halt")) {
                memory.additem(address, "4300");
            } else if (parts.length > 1) {
                String instr = parts[0].toLowerCase();
                String arg = parts[1];
                String opcode = OPCODES.get(instr);
                if (opcode == null) {
                    System.out.println("Unknown instruction: " + instr);
                    continue;
                }

                int operandAddr = resolveAddress(arg, instr);
                String instruction = String.format("%s%02d", opcode, operandAddr);
                memory.additem(address, instruction);
            }
            address++;
        }

        System.out.println("Compilation successful.\n");
    }

    private String preprocessLine(String line) {
        line = line.trim();
        int commentIndex = line.indexOf(';');
        if (commentIndex != -1) line = line.substring(0, commentIndex).trim();
        return line;
    }

    private int resolveAddress(String arg, String currentInstr) {
        if (labelTable.containsKey(arg)) return labelTable.get(arg);

        if (jumpOps.contains(currentInstr.toLowerCase())) {
            System.err.println("Unknown label for jump: " + arg);
            return 0;
        }

        if (variableTable.containsKey(arg)) return variableTable.get(arg);

        if (nextVarAddress < 0) throw new RuntimeException("Out of memory!");
        int addr = nextVarAddress--;
        variableTable.put(arg, addr);
        memory.additem(addr, "0000"); // initialize dynamic variable
        System.out.println("Allocated variable " + arg + " at " + addr);
        return addr;
    }

    private List<String> readSourceFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return lines;
    }
}
