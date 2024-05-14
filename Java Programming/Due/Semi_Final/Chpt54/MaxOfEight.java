public class MaxOfEight {
   public static void main(String[] args) {
      int a = 10, b = 20, c = 30, d = 80, e = 60, f = 70, g = 60, h = 50;
      int max = maxEight(a, b, c, d, e, f, g, h);
      System.out.printf("The maximum value of %d, %d, %d, %d, %d, %d, %d and %d is %d,  ", a, b, c, d, e, f, g, h, max);
   }

   public static int maxEight(int a, int b, int c, int d, int e, int f, int g, int h) {
      int max1 = (a > b) ? a : b;
      int max2 = (c > d) ? c : d;
      int max3 = (e > f) ? e : f;
      int max4 = (g > h) ? g : h;

      int max5 = (max1 > max2) ? max1 : max2;
      int max6 = (max3 > max4) ? max3 : max4;

      return (max5 > max6) ? max5 : max6;
   }
}