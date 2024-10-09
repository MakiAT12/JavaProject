public class Transportion {
   public static void main (String... args) {
      System.out.println("Car subclass:");
      Car car = new Car("Toyota", "Blue", 25, 15);
      car.displayV();       
      car.boost(true);
      car.stop();
      
      System.out.println();
      System.out.println("Truck subclass:");
      Truck truck = new Truck("Ford", "Grey", 120, 150);
      truck.displayV();
      
      System.out.println();
      System.out.println("Tank subclass:");
      Tank tank = new Tank("T-90", "Brown", 60, 1200);
      tank.displayV();
      tank.shoot(10, car.brand);
   }
}