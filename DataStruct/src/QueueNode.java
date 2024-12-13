import  java.util.Scanner;
public class QueueNode {
    Scanner scan = new Scanner(System.in);
    Node first;
    Node last;
    int count;
    byte choice;
    public QueueNode() {
        first = null;
        last = null;
        count = 0;

        while(true) {
            System.out.println("\nQueue Node Operations Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display First Element");
            System.out.println("4. Display Last Element");
            System.out.println("5. Display Queue");
            System.out.println("6. Display Queue w/ First & Last Element");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextByte();

            if(choice == 7)
                break;

            switch(choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    String value = scan.next();
                    enqueue(value);
                    System.out.println("Enqueued " + value);
                    break;
                case 2:
                    if(dequeue())
                        System.out.println("Dequeued successfully.");
                    else
                        System.out.println("Queue is empty, nothing to dequeue.");
                    break;
                case 3:
                    Object first = getFirst();
                    if(first != null)
                        System.out.println("First element: " + first);
                    else
                        System.out.println("Queue is empty.");
                    break;
                case 4:
                    Object last = getLast();
                    if(last != null)
                        System.out.println("Last element: " + last);
                    else
                        System.out.println("Queue is empty.");
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    System.out.print(this);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.tail = newNode;
            last = newNode;
        }
        count++;
    }

    public boolean dequeue() {
        if (!isEmpty()) {
            if (first == last) {
                first = null;
                last = null;
            } else {
                first = first.tail;
            }
            count--;
            return true;
        } else {
            return false;
        }
    }

    public Object getFirst() {
        return isEmpty() ? null : first.data;
    }

    public Object getLast() {
        return isEmpty() ? null : last.data;
    }

    public String toString() {
        String result = "";
        if (!isEmpty()) {
            result += "first = [" + first.data + "]\n";
            result += "last  = [" + last.data + "]\n";

            Node temporary = first;
            while (temporary != null) {
                result += "[" + temporary.data + "]->";
                temporary = temporary.tail;
            }
            result += "\n";
        }
        return result;
    }

    public void display() {
        if (!isEmpty()) {
            Node temporary = first;
            while (temporary != null) {
                System.out.print("[" + temporary.data + "]->");
                temporary = temporary.tail;
            }
            System.out.println();
        } else {
            System.out.println("Queue is empty...");
        }
    }
}