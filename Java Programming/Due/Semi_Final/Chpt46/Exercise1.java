class HelloObject {
    private String greeting;
    public HelloObject(String greeting) {
        this.greeting = greeting;
    }
    public void speak() {
        for (int i = 0; i < greeting.length(); i++) 
            System.out.println(greeting);
    }
}
public class Exercise1 {
    public static void main(String[] args) {
        HelloObject hello = new HelloObject("Hello");
        hello.speak();
    }
}