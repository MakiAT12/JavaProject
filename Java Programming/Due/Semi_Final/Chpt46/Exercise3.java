import java.util.Scanner;
class HelloObject {
    private String greeting;
    public HelloObject(String greeting) {
        this.greeting = greeting;
    }

    public void speak() {
        System.out.println("\n"+greeting);
    }
}
public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Greeting:");
        String userGreeting = scanner.nextLine();
        scanner.close();

        HelloObject hello = new HelloObject(userGreeting);
        hello.speak();
    }
}