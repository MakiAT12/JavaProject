public class Memory{
   private int size=100;
   private String[] mem;
   
   public Memory(int size){
      this.size=size;
      mem = new String[size];
   }
   
   
   public Memory(String[] data){
      int datasize = data.length;
      mem = new String[size];      
      for(int i=0;i<datasize; mem[i]=data[i],i++);
   }
   
   public void additem(int address,String data){
      this.mem[address] = data;
   }
   
   public String getitem(int address){
      return this.mem[address];
   }
   public int size() { return mem.length; }
   
   public void dump(){
      for(int i=0;i<size;i++){
            String data=mem[i];
            if (mem[i]==null) data="0000"; 
            if((i%10)==0) System.out.printf("\n+%4s ",data);
            else System.out.printf("+%4s ",data);
            
      }
      System.out.println("\n------------------------------------------------------------");
   }
   
   static public void main(String... args){
      Memory m = new Memory(new String[]{"1007","1008","2007","3008","2109","1109","4300"});
      m.dump();
      m.additem(90,"1000");
   }
}