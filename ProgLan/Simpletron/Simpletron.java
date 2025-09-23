import java.io.File;
import java.util.Scanner;

public class Simpletron {
    private int pc;
    private String ir;
    private String opcode;
    private String operand;
    private Memory memory;
    private int accumulator;

    private String filename;
    private boolean running;
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public Simpletron(String filename) {
        this.filename = filename;
        this.memory = new Memory(100);
        this.pc = 0;
        this.accumulator = 0;
        this.running = true;
    }

    public void run() {
        loadProgram(); 
        while (running) {
            fetch(pc);
            decode(opcode);
            pc++;
        }
        System.out.println("*** Program halted ***");
    }

    public void step() {
        loadProgram();
        while (running) {
            fetch(pc);

            System.out.println("\n--- STEP ---");
            System.out.println("PC: " + pc);
            System.out.println("IR: " + ir);
            System.out.println("Opcode: " + opcode);
            System.out.println("Operand: " + operand);
            System.out.println("Accumulator: " + accumulator);
            memory.dump();

            if ("43".equals(opcode)) {
                running = false;
                break;
            }

            if ("10".equals(opcode)) {
                decode(opcode);
                pc++;
                continue;
            }

            System.out.print(
                    "\nPress Enter to execute this instruction, or type 'q' + Enter to quit stepping: ");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("q")) {
                System.out.println("Stepping aborted by user.");
                return;
            }

            decode(opcode);
            pc++;
        }

        System.out.println("*** Program halted ***");
    }

    private void loadProgram() {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();

                if (line.isEmpty() || line.startsWith(";"))
                    continue;

                String[] parts = line.split("\\s+");
                int address = Integer.parseInt(parts[0]);
                String instruction = parts[1];

                memory.additem(address, instruction);
            }
        } catch (Exception e) {
            System.out.println("Error loading program: " + e.getMessage());
            running = false;
        }
    }

    public String fetch(int address) {
        ir = memory.getitem(address);
        if (ir == null) {
            System.out.println("No instruction at address " + address);
            running = false;
            return null;
        }
        opcode = ir.substring(0, 2);
        operand = ir.substring(2);
        return ir;
    }

    public void store(int address) {
        memory.additem(address, String.valueOf(accumulator));
    }

    public void decode(String opcode) {
        int address = Integer.parseInt(operand);
        switch (opcode) {
            case "10": // READ memory[address]
                System.out.print("? ");
                String input = scanner.nextLine();
                memory.additem(address, input);
                break;
            case "11": // WRITE memory[address]
                System.out.println("> " + memory.getitem(address));
                break;
            case "20": // LOAD from memory
                accumulator = Integer.parseInt(memory.getitem(address));
                break;
            case "21": // STORE to memory
                store(address);
                break;
            case "22": // LOAD immediate
                accumulator = address;
                break;
            case "30": // ADD from memory
                accumulator += Integer.parseInt(memory.getitem(address));
                break;
            case "31": // SUB from memory
                accumulator -= Integer.parseInt(memory.getitem(address));
                break;
            case "32": // DIV from memory
                int divisorM = Integer.parseInt(memory.getitem(address));
                if (divisorM == 0)
                    throw new ArithmeticException("Division by zero");
                accumulator /= divisorM;
                break;
            case "33": // MOD from memory
                accumulator %= Integer.parseInt(memory.getitem(address));
                break;
            case "34": // MUL from memory
                accumulator *= Integer.parseInt(memory.getitem(address));
                break;
            case "35": // ADD immediate
                accumulator += address;
                break;
            case "36": // SUB immediate
                accumulator -= address;
                break;
            case "37": // DIV immediate
                if (address == 0)
                    throw new ArithmeticException("Division by zero");
                accumulator /= address;
                break;
            case "38": // MOD immediate
                accumulator %= address;
                break;
            case "39": // MUL immediate
                accumulator *= address;
                break;
            case "40": // JMP
                pc = address - 1;
                break;
            case "41": // JN
                if (accumulator < 0)
                    pc = address - 1;
                break;
            case "42": // JZ
                if (accumulator == 0)
                    pc = address - 1;
                break;
            case "43": // HALT
                running = false;
                break;
            default: // unknown operation
                System.out.println("Unknown operation: " + opcode);
                running = false;
                break;
        }
    }

    public static void main(String... args) {
        String filename = "test.txt";
        boolean stepMode = false;

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("step")) {
                stepMode = true;
            } else {
                filename = args[0];
            }
        } else if (args.length >= 2) {
            filename = args[0];
            if (args[1].equalsIgnoreCase("step")) {
                stepMode = true;
            }
        }

        Simpletron s = new Simpletron(filename);
        if (stepMode) {
            s.step();
        } else {
            s.run();
        }
    }
}