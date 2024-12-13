import  java.util.Scanner;
class NodeList {

    Scanner scan = new Scanner(System.in);
    private Node head;
    private int count;
    byte choice;
    public NodeList() {
        head = null;
        count = 0;

        while(true) {
            System.out.println("\nNode List Operations Menu:");
            System.out.println("1. add an item");
            System.out.println("2. delete specific an item");
            System.out.println("3. Display node list");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextByte();

            if(choice == 4)
                break;

            switch(choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    String value = scan.next();

                    if(add(new Node(value)))
                        System.out.println("Item pushed");
                    else
                        System.out.println("Stack is full");
                    break;
                case 2:
                    System.out.print("Enter a specified index node to be deleted: ");
                    byte index = scan.nextByte();
                    if(delete(index))
                        System.out.println("Delete successfully.");
                    else
                        System.out.println("Stack is empty, nothing to pop.");
                    break;
                case 3:
                    display();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private boolean isEmpty() {
        return count == 0;
    }

    public boolean add(Node item) {
        if (item == null)
            return false;

        item.tail = head;
        head = item;
        count++;
        return true;
    }

    public boolean delete(int indexCount) {
        if (isEmpty() || indexCount < 0 || indexCount >= count) {
            System.out.println("Delete out of bounds. Check display for details.");
            return false;
        }

        if (indexCount == 0) {
            head = head.tail;
            count--;
            return true;
        }

        Node current = head;
        for (int i = 0; i < indexCount - 1; i++)
            current = current.tail;

        if (current.tail != null) {
            current.tail = current.tail.tail;
            count--;
            return true;
        }

        return false;
    }

    public void display() {
        if (!isEmpty()) {
            Node temporary = head;
            int index = 0;
            while (temporary != null) {
                System.out.println("[" + temporary.data + "] = Index: " + index++);
                temporary = temporary.tail;
            }
            System.out.println("\nCount: " + count + "\n");
        } else
            System.out.println("List is empty....");

    }
}