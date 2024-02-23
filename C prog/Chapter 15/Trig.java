import java.util.Scanner;
import java.lang.Math;
   public class Trig{
      public static void main(String[] args){
         Scanner scan = new Scanner(System.in);
         double sumSin, sumCos;
         
         System.out.print("Input an angle: ");
         float angle = scan.nextFloat();
         System.out.printf("sin(%.2f)\t is:%6.2f\n", angle, Math.sin(Math.toRadians(angle)));
         System.out.printf("sin(%.2f)\t is:%6.2f\n", angle, Math.cos(Math.toRadians(angle)));
         System.out.printf("sin(%.2f)^2 is:%6.2f\n", angle, sumSin = (Math.pow(Math.sin(Math.toRadians(angle)), 2)));
         System.out.printf("sin(%.2f)^2 is:%6.2f\n", angle, sumCos = (Math.pow(Math.cos(Math.toRadians(angle)), 2)));
         System.out.printf("sum\t\t\t is:%6.2f\n", (sumSin +  sumCos));
      }
   }