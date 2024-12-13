import java.util.Scanner;
public class StackList {
    Scanner scan = new Scanner(System.in);
    private Node top;
    private int count;
    byte choice;
    public StackList() {
        top = null;
        count = 0;

        while(true) {
            System.out.println("\nStack List Operations Menu:");
            System.out.println("1. Push an item");
            System.out.println("2. Pop an item");
            System.out.println("3. Peek the stack");
            System.out.println("4. Display stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextByte();

            if(choice == 5)
                break;

            switch(choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    String value = scan.next();

                    if(push(value))
                        System.out.println("Item pushed");
                    else
                        System.out.println("Stack is full");
                    break;
                case 2:
                    if(pop())
                        System.out.println("Pop successfully.");
                    else
                        System.out.println("Stack is empty, nothing to pop.");
                    break;
                case 3:
                    if(peek() != null)
                        System.out.println("Top item is "+peek());
                    else
                        System.out.println("Stack is empty.");
                    break;
                case 4:
                    display();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean push(String data) {
        Node node = new Node(data);
        node.tail = top;
        top = node;
        count++;
        return true;
    }
    public boolean pop() {
        if (!isEmpty()) {
            top = top.tail;
            count--;
            return true;
        }
        return false;
    }
    public String peek() {
        if (!isEmpty()) {
            return top.data;
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public void display() {
        if (!isEmpty()) {
            Node temporary = top;
            while (temporary != null) {
                System.out.println(temporary.data);
                temporary = temporary.tail;
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty....");
        }
    }
}
