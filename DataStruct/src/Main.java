import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        byte choice = 0;
        int size = 10;

        while (true) {
            System.out.println("Choose a Program to enter");
            System.out.println("[1] Stack Array");
            System.out.println("[2] Stack List");
            System.out.println("[3] Node List");
            System.out.println("[4] Queue Array");
            System.out.println("[5] Queue Node");
            System.out.println("[6] Infix to Postfix Conversion/Evaluation");
            System.out.println("[7] Sum and Product");
            System.out.println("[8] Odd and Even ");
            System.out.println("[9] No Duplication number");
            System.out.println("[10] Largest to Smallest");
            System.out.println("[11] Exit program");
            System.out.print("Enter your choice: ");
            choice = scan.nextByte();
            scan.nextLine();

            if (choice == 11)
                break;

            switch (choice) {
                case 1:
                    System.out.println("Enter size of the Stack:");
                    size = scan.nextInt();
                    scan.nextLine();
                    new StackArray(size);
                    break;
                case 2:
                    new StackList();
                    break;
                case 3:
                    new NodeList();
                    break;
                case 4:
                    System.out.println("Enter size of the Queue:");
                    size = scan.nextInt();
                    scan.nextLine();
                    new QueueArray(size);
                    break;
                case 5:
                    new QueueNode();
                    break;
                case 6:
                        System.out.print("Enter Infix expression: ");
                        String infix = scan.nextLine();
                        InfixToPostfix itp = new InfixToPostfix(infix);
                        String postfix = itp.convert();
                        System.out.println("Infix: " + infix + " --> Postfix: " + postfix);
                        System.out.println("Evaluation of " + infix + " is: " + itp.evaluate(postfix));
                        System.out.println();
                    break;
                case 7:
                    new SumAndProduct();
                    break;
                case 8:
                    new OddEven();
                    break;
                case 9:
                    new NoDup();
                    break;
                case 10:
                    new LargeToSmall();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        System.out.println("System Exit");
    }
}
