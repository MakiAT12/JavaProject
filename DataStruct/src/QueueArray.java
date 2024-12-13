import java.util.*;
public class QueueArray {
    Scanner scan = new Scanner(System.in);
    private Object[] items;
    private int count;
    byte choice;
    public QueueArray(int size){
        items = new Object[size <= 0? size = 10:size];
        count = 0;

        while(true) {
            System.out.println("\nQueue Array Operations Menu:");
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

                    if(enqueue(value))
                        System.out.println("Item pushed");
                    else
                        System.out.println("Stack is full");
                    break;
                case 2:
                    if(dequeue())
                        System.out.println("Pop successfully.");
                    else
                        System.out.println("Stack is empty, nothing to pop.");
                    break;
                case 3:
                    if(front() != null)
                        System.out.println("Front item of the queue is "+front());
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
    public QueueArray(){
        this(10);
    }
    private boolean isEmpty(){
        return count == 0;
    }
    private boolean isFull(){
        return count == items.length;
    }
    public boolean enqueue(Object val){
        if(!isFull()){
            items[count++] = val;
            return true;
        }
        return false;
    }
    public boolean dequeue(){
        if(!isEmpty()){
            for(int i = 1; i < count; i++)
                items[i-1] = items[i];
            items[count - 1] = null;
            count--;
            return true;
        }
        return false;
    }
    public Object front(){
        if(!isEmpty()){
            return items[0];
        }
        return null;
    }
    public void display(){
        if(!isEmpty()){
            for(int i = 0; i < count; i++){
                System.out.println("["+items[i]+"]");
            }
        }
        else
            System.out.println("Stack is empty");
    }
}