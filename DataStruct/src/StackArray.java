import java.util.Scanner;
class StackArray {
    Scanner scan = new Scanner(System.in);
    String[] arr;
    int count, choice;

    public StackArray(int size) {
        arr = new String[size];
        count = 0;

        while(true) {
            System.out.println("\nStack Array Operations Menu:");
            System.out.println("1. Push an item");
            System.out.println("2. Pop an item");
            System.out.println("3. Peek the stack");
            System.out.println("4. Display stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            if(choice == 5)
                break;

            switch(choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    String value = scan.next();

                    if(push(value)) System.out.println("Item pushed");
                    else System.out.println("Stack is full");
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

    public boolean push(String val) {
        if(!isFull()) {
            arr[count++] = val;
            return true;
        }
        return false;
    }

    public boolean pop() {
        if(!isEmpty()) {
            arr[count - 1] = null;
            count--;
            return true;
        }
        return false;
    }

    public String peek() {
        return arr[count-1];
    }
    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        if(count == arr.length) {
            return true;
        }
        return false;
    }

    public void display() {
        for(int i = count - 1; i >= 0 ; i--) {
            System.out.println(arr[i]);
        }
    }
}