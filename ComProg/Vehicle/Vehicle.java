  class Vehicle {
   String brand, color;
   int fuel, speed;
   
   Vehicle(String brand, String color,int speed, int fuel){
      this.brand = brand;
      this.color = color;
      this.speed = speed;
      this.fuel = fuel;
   }
   public  void go() {
      System.out.println(brand+" is moving.");
   }
   public  void stop() {
      System.out.println(brand+" has stopped.");
   }
   public  void refuel(int amount ) {
      fuel += amount;
      System.out.println("Fuel increased by " + amount +" "+(fuel == 1 ? "liter" : "liters")+". Total fuel: " + fuel+" "+(fuel == 1 ? "liter" : "liters"));
   }
   public void displayV() {
      System.out.println("Brand: " + brand +
                         "\nColor: " + color +
                         "\nSpeed: " + speed + " km/h" +
                         "\nFuel: " + fuel + " " + (fuel == 1 ? "liter" : "liters"));
   }   
}
   class Car extends Vehicle {
   int doors;
   boolean nitro;
   
   Car(String brand, String color,int speed, int fuel) {
      super(brand, color, speed, fuel);
   }
   public void drift() {
      System.out.println(brand+" is drifting.");
   }
   public void boost(boolean nitro) {
      if(nitro)
         System.out.println("The "+brand+" uses nitro and is boosted.");
       else
         System.out.println("The "+brand+" has no nitro and is not boosted.");
   }
}   
   class Truck extends Vehicle {
   int payloadCapacity;
   int wheels;
   
   Truck(String brand, String color,int speed, int fuel) {
      super(brand, color, speed, fuel);
   }
   public void payload(int payload) {
      System.out.println(brand+" is drifting.");
   }
   public void numberOfWheels(int wheels) {
      System.out.println(brand+" is boosted.");
   }
}
class Tank extends Vehicle {
   int shells;
   String Armor;
   
   Tank(String brand, String color,int speed, int fuel) {
      super(brand, color, speed, fuel);
   }
   public void shoot(int shells, String vehicle) {
      System.out.println("The "+color+" "+brand+" fired a tank sheel at the "+vehicle+" and got demolished.");
   }
   public void typeArmor(boolean nitro) {
      System.out.println(brand+" is boosted.");
   }
}