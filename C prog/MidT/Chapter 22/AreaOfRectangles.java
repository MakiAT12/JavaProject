import java.util.Scanner;
public class AreaOfRectangles{
   public static void main (String[] args) {
      Scanner scan = new Scanner(System.in);
      int width = 1, height = 1, area;
      while (width != 0 && height != 0) {
         System.out.println("\nFirst corner X coordinate: ");
         int firstX = scan.nextInt();
         System.out.println("First corner Y coordinate: ");
         int firstY = scan.nextInt();
         System.out.println("Second corner X coordinate: ");
         int secondX = scan.nextInt();
         System.out.println("Second corner Y coordinate ");
         int secondY = scan.nextInt();
         width = Math.abs(firstX - secondX);
         height = Math.abs(firstY - secondY);
         area = width * height;
         System.out.println("Width: "+width+"  Height: "+height+"   Area: "+area);
      }
      System.out.println("\nfinished");
   }
}