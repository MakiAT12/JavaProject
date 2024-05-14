class HelloObject {
    private String greeting;

    // Default constructor
    public HelloObject() {
        greeting = "";
    }

    // Constructor taking a greeting string
    public HelloObject(String greeting) {
        this.greeting = greeting;
    }

    // Constructor taking another HelloObject
    public HelloObject(HelloObject init) {
        // Create a new String object for the greeting
        this.greeting = new String(init.greeting);
    }

    public void speak() {
        System.out.println(greeting);
    }
}

public class Excercise4 {
    public static void main(String[] args) {
        HelloObject hello1 = new HelloObject("Hello World!");
        HelloObject hello2 = new HelloObject(hello1);

        hello1.speak(); // Output: Hello World!
        hello2.speak(); // Output: Hello World!
    }
}
