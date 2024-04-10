public class ReverseOrder {
    public static void main ( String[] args )
  {
    int[] val = {0, 1, 2, 3}; 
    int[] temp = new int[val.length];
    
    System.out.println( "Original Array: " + val[0] + " " + val[1] + " " + val[2] + " " + val[3] );
    temp[0] = val[0];
    temp[1] = val[1];
    temp[2] = val[2];
    temp[3] = val[3];
    val[0] = temp[3];
    val[1] = temp[2];
    val[2] = temp[1];
    val[3] = temp[0];
    System.out.println( "Reversed Array: " + val[0] + " " + val[1] + " " + val[2] + " " + val[3] );
   }
}
