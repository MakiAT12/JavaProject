class HelloObject {
    private String morningGreeting;
    private String eveningGreeting;

    public HelloObject(String morningGreeting, String eveningGreeting) {
        this.morningGreeting = morningGreeting;
        this.eveningGreeting = eveningGreeting;
    }

    public void speakMorning() {
        System.out.println("Good morning " + morningGreeting + "!");
    }

    public void speakEvening() {
        System.out.println("Good evening " + eveningGreeting + "!");
    }
}

public class Exercise2 {
    public static void main(String[] args) {
        HelloObject hello = new HelloObject("World", "World");
        hello.speakMorning();
        hello.speakEvening();
    }
}
