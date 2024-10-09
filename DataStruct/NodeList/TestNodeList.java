// Name: Bj S. Camporedondo   Course: BSCS 2A    Date: 10/5/24

class NodeList {
   public class Node {
      String data;
      Node tail;
   
      public Node(String data) {
         this.data = data;
         this.tail = null;
      }
   }

   private Node head;
   private int count;

   public NodeList() {
      head = null;
      count = 0;
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
         System.out.println("Delete out of bounds.");
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
public class TestNodeList {
   public static void main(String[] args) {
      NodeList list = new NodeList();
      list.add(list.new Node("Node 1"));
      list.add(list.new Node("Node 2"));
      list.add(list.new Node("Node 3"));
      list.add(list.new Node("Node 4"));
      list.add(list.new Node("Node 5"));
      list.add(list.new Node("Node 6"));
   
      System.out.println("Initial List:");
      list.display();
   
      list.delete(0);
      System.out.println("After deleting index 0:");
      list.display();
   
      list.delete(2);
      System.out.println("After deleting index 2:");
      list.display();
   
      list.delete(0);
      System.out.println("After deleting index 0:");
      list.display();
   }
}