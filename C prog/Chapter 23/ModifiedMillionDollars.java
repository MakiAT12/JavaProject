public class   ModifiedMillionDollars {
   public static void main( String[] args ) {
      double initialAmount = 1000.00 ;
      double dollars = 0.0;
      double rate = -0.001 ;
 
      while ( dollars < 1000000 ) {
         // change to the next rate
         rate = rate + 0.001;

         // compute the dollars after 40 years at the current rate
         int year =  1 ;     
         dollars = initialAmount;     
         while (  year <= 40 ) {     
            dollars = dollars + dollars*rate  ; // add another year's interest     
            dollars = dollars + 1000 ;          // add in this year's contribution
            year    =  year + 1 ;
         }
      }
      System.out.println("After 40 years at " + rate*100 + " percent interest you will have " + dollars + " dollars" );
   }
}