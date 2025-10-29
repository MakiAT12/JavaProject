import java.util.*;

public class SimpletronProcessorEngine {
    private int pc;
    private String ir;
    private String opcode;
    private String operand;
    private Memory memory;
    private int accumulator;
    private boolean running;

    // Tracks all memory addresses that have been executed or written to
    private final Set<Integer> revealedMemory = new HashSet<>();

    private static final Scanner scanner = new Scanner(System.in);

    public SimpletronProcessorEngine(Memory memory) {
        this.memory = memory;
        this.pc = 0;
        this.accumulator = 0;
        this.running = true;
    }

    public void run() {
        skipEmptyMemory();
        while (running) {
            fetch(pc);
            if (!running) break;
            decode(opcode);
            revealedMemory.add(pc); // reveal executed instruction
            pc++;
        }
        System.out.println("Memory Dump:");
        memory.dump();
        System.out.println("*** Program halted ***");
    }

    public void step() {
        skipEmptyMemory();

        while (running) {
            fetch(pc);
            if (!running) break;

            System.out.println("\n--- STEP ---");
            System.out.println("Address: " + pc);
            System.out.println("IR: " + ir);
            System.out.println("Opcode: " + opcode);
            System.out.println("Operand: " + operand);
            System.out.println("Accumulator: " + accumulator);

            revealedMemory.add(pc); // reveal current instruction

            System.out.println("\nMemory Dump:");
            memoryDump();
            System.out.print("------------------------------------------------------------\n");

            if ("43".equals(opcode)) { // HALT
                running = false;
                break;
            }

            System.out.print("\nPress Enter to execute next, or 'q' + Enter to quit: ");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("q")) {
                System.out.println("Stepping aborted by user.");
                return;
            }

            decode(opcode);
            revealedMemory.add(pc); // reveal instruction after execution (in case of writes)

            System.out.println("\n--- After Execution ---");
            memoryDump();

            pc++;
        }
        System.out.println("*** Program halted ***");
    }

    private void memoryDump() {
        int size = 100;
        int itemsPerLine = 10;

        for (int i = 0; i < size; i++) {
            String data = memory.getitem(i);
            if (data == null || data.trim().isEmpty()) data = "0000";

            // show memory if executed or written to
            if (!revealedMemory.contains(i)) data = "0000";

            if (i % itemsPerLine == 0) System.out.print("\n");
            System.out.printf("+%4s ", data);
        }
        System.out.println();
    }

    private void skipEmptyMemory() {
        while (pc < 100) {
            String val = memory.getitem(pc);
            if (val != null && !val.trim().isEmpty() && !val.equals("0000")) return;
            pc++;
        }
        running = false;
    }

    private void fetch(int address) {
        ir = memory.getitem(address);
        if (ir == null || ir.trim().isEmpty() || ir.equals("0000")) {
            running = false;
            return;
        }
        ir = ir.trim();
        opcode = ir.substring(0, 2);
        operand = ir.substring(2);
    }

    private void store(int address) {
        memory.additem(address, String.format("%04d", accumulator));
        revealedMemory.add(address); // reveal memory after store
    }

    private void decode(String opcode) {
        int address = Integer.parseInt(operand);

        switch (opcode) {
            case "10": // READ
                System.out.print("? ");
                String input = scanner.nextLine().trim();
                int value;
                try {
                    value = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    value = 0;
                }
                memory.additem(address, String.format("%04d", value));
                revealedMemory.add(address); // reveal memory after read
                break;

            case "11": // WRITE
                String val = memory.getitem(address);
                if (val == null || val.trim().isEmpty()) val = "0";
                System.out.println("> " + Integer.parseInt(val));
                break;

            case "20": accumulator = Integer.parseInt(memory.getitem(address)); break;
            case "21": store(address); break;
            case "22": accumulator = address; break;
            case "30": accumulator += Integer.parseInt(memory.getitem(address)); break;
            case "31": accumulator -= Integer.parseInt(memory.getitem(address)); break;
            case "32": accumulator /= Integer.parseInt(memory.getitem(address)); break;
            case "33": accumulator %= Integer.parseInt(memory.getitem(address)); break;
            case "34": accumulator *= Integer.parseInt(memory.getitem(address)); break;
            case "35": accumulator += address; break;
            case "36": accumulator -= address; break;
            case "37": accumulator /= address; break;
            case "38": accumulator %= address; break;
            case "39": accumulator *= address; break;
            case "40": pc = address - 1; break;
            case "41": if (accumulator < 0) pc = address - 1; break;
            case "42": if (accumulator == 0) pc = address - 1; break;
            case "43": running = false; break;
            default: System.out.println("Unknown operation: " + opcode); running = false; break;
        }
    }

    public static void main(String[] args) {
        String filename = "test.txt";
        boolean stepMode = false;

        if (args.length >= 1) filename = args[0];
        if (args.length >= 2 && args[1].equalsIgnoreCase("step")) stepMode = true;

        Memory memory = new Memory(100);
        CompilerProgram compiler = new CompilerProgram(memory);
        compiler.compile(filename);

        SimpletronProcessorEngine s = new SimpletronProcessorEngine(memory);
        if (stepMode) s.step();
        else s.run();
    }
}