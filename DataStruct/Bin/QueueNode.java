import java.util.Scanner;

class Node {
   Object value;
   Node next;

   public Node(Object value) {
      this.value = value;
      next = null;
   }
}

public class QueueNode {
   Node first;
   Node last;
   int count;

   public QueueNode() {
      first = null;
      last = null;
      count = 0;
   }

   public boolean isEmpty() {
      return first == null && last == null;
   }

   public boolean enqueue(Object value) {
      Node newNode = new Node(value);
      if(isEmpty()) {
         first = newNode;
         last = newNode;
      } else {
         last.next = newNode;
         last = newNode;
      }
      count++;
      return true;
   }

   public boolean dequeue() {
      if(!isEmpty()) {
         if(first == last) {
            first = null;
            last = null;
         } else {
            first = first.next;
         }
         count--;
         return true;
      } else {
         return false;
      }
   }

   public Object getFirst() {
      return isEmpty() ? null : first.value;
   }

   public Object getLast() {
      return isEmpty() ? null : last.value;
   }

   public String toString() {
      String result = "";
      if(!isEmpty()) {
         result += "first = [" + first.value + "]\n";
         result += "last  = [" + last.value + "]\n";
      
         Node temporary = first;
         while(temporary != null) {
            result += "[" + temporary.value + "]->";
            temporary = temporary.next;
         }
         result += "\n";
      }
      return result;
   }

   public void display() {
      if(!isEmpty()) {
         Node temporary = first;
         while(temporary != null) {
            System.out.print("[" + temporary.value + "]->");
            temporary = temporary.next;
         }
         System.out.println();
      } else {
         System.out.println("Queue is empty...");
      }
   }

   public static void main(String[] args) {
      QueueNode queue = new QueueNode();
      Scanner scan = new Scanner(System.in);
      int choice;
   
      while(true) {
         System.out.println("\nQueue Operations Menu:");
         System.out.println("1. Enqueue");
         System.out.println("2. Dequeue");
         System.out.println("3. Display First Element");
         System.out.println("4. Display Last Element");
         System.out.println("5. Display Queue");
         System.out.println("6. Display Queue w/ First & Last Element");
         System.out.println("7. Exit");
         System.out.print("Enter your choice: ");
         choice = scan.nextInt();
         
         if(choice == 7)
            break;
      
         switch(choice) {
            case 1:
               System.out.print("Enter value to enqueue: ");
               Object value = scan.next();
               queue.enqueue(value);
               System.out.println("Enqueued " + value);
               break;
            case 2:
               if(queue.dequeue()) 
                  System.out.println("Dequeued successfully.");
               else 
                  System.out.println("Queue is empty, nothing to dequeue.");
               break;
            case 3:
               Object first = queue.getFirst();
               if(first != null) 
                  System.out.println("First element: " + first);
               else 
                  System.out.println("Queue is empty.");
               break;
            case 4:
               Object last = queue.getLast();
               if(last != null) 
                  System.out.println("Last element: " + last);
               else 
                  System.out.println("Queue is empty.");
               break;
            case 5:
               queue.display();
               break;
            case 6:
               System.out.print(queue.toString());
               break;
            default:
               System.out.println("Invalid choice, please try again.");
         }
      }
   }
}