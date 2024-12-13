import java.util.Scanner;
public class OddEven {
    OddEven() {
        Scanner input = new Scanner(System.in);
        int[] even = new int[10];
        int[] odd = new int[10];
        int num;
        int count_even = 0, count_odd = 0, count = 0;

        System.out.println("Enter 10 numbers:");
        for(count = 0; count < 10; count++)
        {
            num = input.nextInt();
            if(num % 2 == 0)
                even[count_even++] = num;
            else
                odd[count_odd++] = num;
        }

        System.out.println("Even\tOdd");
        for(int i=0; i<count; i++)
        {
            if(count_even > i)
                System.out.printf("%5d\t", even[i]);
            else
                System.out.printf("\t");

            if(count_odd > i)
                System.out.printf("%5d\n", odd[i]);
            else
                System.out.printf("\n");
        }
    }
}
