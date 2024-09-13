/*
   create a java program that will allow the user
   to enter 3 numbers, display the highest number.
*/

import java.util.*;
public class Largest1 
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      int x, y, z;
      
      System.out.println("Enter 3 numbers:");
      x = keyboard.nextInt();
      y = keyboard.nextInt();
      z = keyboard.nextInt();
      
      if(x > y)
      {
         if(x > z)
            System.out.println(x);
         else
            System.out.println(z);
      }
      else 
      {
         if(y > z)
            System.out.println(y);
         else
            System.out.println(z);
      }
      
      
      
      
      
      
   }
}