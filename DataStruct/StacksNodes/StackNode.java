public class StackList 
{
   private StackNode top;
   private int count;
   
   public StackList()
   {
      top = null;
      count = 0;
   }
   private boolean isEmpty()
   {
      //return top == null;
      return count == 0;
   }
   public boolean push(String data)
   {
      StackNode node = new StackNode(data);
      node.tail = top;
      top = node;
      count++;
      return true;
   }
   
   public boolean pop()
   {
      if(!isEmpty())
      {
         top = top.tail;
         count--;
         return true;
      }
      return false;
   }
   public String peek()
   {
      if(!isEmpty())
      {
         return top.data;
      }
      return null;
   }
   public int getcount()
   {
      return count;
   }
   
   public void display()
   {
      if(!isEmpty())
      {
         StackNode temporary = top;
         while(temporary != null)
         {
            System.out.println(temporary.data);
            temporary = temporary.tail;
         }
         System.out.println();
      }
      else 
      {
         System.out.println("Stack is empty....");
      }
   }
   public static void main(String[] args)
   {
      StackList sl = new StackList();
      sl.push("java");
      sl.push("ccs");
      sl.push("uc");
      sl.push("it");
      sl.display();
      sl.push("cs");
      sl.display();
      sl.pop();
      sl.pop();
      sl.display();
      sl.push("c++");
      sl.display();
   }
}
