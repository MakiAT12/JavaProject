import java.util.*;
public class QueueArray {
   private Object[] items;
   private int count;
	
   public QueueArray(int size){
      items = new Object[size <= 0? size = 10:size];
      count = 0;
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