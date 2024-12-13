import java.util.Scanner;
public class LargeToSmall {
    LargeToSmall(){
                Scanner keyboard = new Scanner(System.in);
                int x, y, z;

                System.out.println("Enter 3 numbers:");
                x = keyboard.nextInt();
                y = keyboard.nextInt();
                z = keyboard.nextInt();

                if(y > x)
                    x = y;
                if(z > x)
                    x = z;
                System.out.println("The large number is:"+x);
    }
}
