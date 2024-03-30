import java.util.Random; // this code generate random name for the user
public class RandomNames {
   public static void main(String[] args) {
      Random random = new Random(); // Create a Random object
      int randomFirstNameIndex = random.nextInt(10);  // Generate random indices to pick random first and last names
      int randomLastNameIndex = random.nextInt(10);   // Retrieve random first and last names using the generated indices
      String firstName;
      String lastName;
        
      switch (randomFirstNameIndex) { // First name randomizer
         case 0: firstName = "Bj"; break;
         case 1: firstName = "Arron"; break;
         case 2: firstName = "Christian Kyle"; break;
         case 3: firstName = "John Russel"; break;
         case 4: firstName = "Jerhon"; break;
         case 5: firstName = "Haggai"; break;
         case 6: firstName = "Genne"; break;
         case 7: firstName = "Jun Marc"; break;
         case 8: firstName = "John Paul"; break;
         case 9: firstName = "Clark John"; break;
         default: firstName = "Unknown"; break;
      }       
      switch (randomLastNameIndex) { // last name randomizer
         case 0: lastName = "Smith"; break;
         case 1: lastName = "Johnson"; break;
         case 2: lastName = "Williams"; break;
         case 3: lastName = "Jones"; break;
         case 4: lastName = "Brown"; break;
         case 5: lastName = "Davis"; break;
         case 6: lastName = "Miller"; break;
         case 7: lastName = "Wilson"; break;
         case 8: lastName = "Moore"; break;
         case 9: lastName = "Taylor"; break;
         default: lastName = "Unknown"; break;
      }
      System.out.println("Randomly generated name: "+ firstName + " " + lastName);
   }
}