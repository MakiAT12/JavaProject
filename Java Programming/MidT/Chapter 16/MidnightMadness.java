import java.util.Scanner;
public class MidnightMadness{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("This is a ticket price indicator depending on the age and time with the new 10am policy discount ticket price.");
        System.out.println("Enter your Age: ");
        byte age = scan.nextByte();
        System.out.println("Enter time to watch on a 24 hour clock (ex. 9:30pm is 2130; 9:30am is 930): ");
        int time = scan.nextInt();

        if(age > 0 && time >= 100 && time <= 2400){
            if(age > 13) {
                if(time >= 2200)
                    System.out.println("10am policy price ticket is $4.00");
                else if(time < 1700)
                    System.out.println("\nAdult's \"matinee time\" (1am - 5pm) price ticket is $5.00");
                else
                    System.out.println("\nAdult's \"non-matinee time\" (1am - 5pm) price ticken is $8.00");
            }   
            else {
                if(time >= 2200)
                    System.out.println("Childrens cannot purchase the 10am discout ticket price");
                else if(time < 1700)
                    System.out.println("\nChildren's matinee (under 5pm) price ticket is $2.00");
                else
                    System.out.println("\nChildren's non-matinee (under 5pm) price ticken is $4.00");
            }
        }
        else
            System.out.println("Invalid input, must enter according to the instruction");    
    }
}