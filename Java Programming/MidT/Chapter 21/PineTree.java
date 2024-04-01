import java.util.Scanner;
public class PineTree {
   public static void main (String[] ags) {
      Scanner scan = new Scanner(System.in);      
      int i = 1, j , n = 11;
         
      while (i <= n) {
         if (i <= 8) {
            j = 1;
            while(j <= (n - i)) {
               System.out.print(" ");
               j++;
            }
            j = 1;
            while(j <= 2 * i - 1) {
               System.out.print("*");
               j++;
            }
         }
         if (i > 8) {
            j = 1;
            while(j <= n + 1) {
               if (j <= 9)
                  System.out.print(" ");
               else 
                  System.out.print("*");
               j++;                 
            }      
         } 
         System.out.println();
         i++;      
      }
   }
}