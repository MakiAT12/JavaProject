class DivideConquer{
   static void Merge(int[] array, int left, int mid, int right){
      int n1 = mid - left + 1;
      int n2 = right - mid;
      
      int[] leftArray = new int[n1];
      int[] rightArray = new int[n2];
      
      for(int i = 0; i < n1; i++)
         leftArray[i] = array[left + 1];
      for(int j = 0; j < n2; j++)
         rightArray[j] = array[mid + 1 + j];
      
      int iIndex = 0 , jIndex = 0,  kIndex = left;   
      while(iIndex < n1 && jIndex < n2){
         if(leftArray[iIndex] <= rightArray[jIndex]) array[kIndex] = leftArray[iIndex++];
         else array[kIndex] = rightArray[jIndex++];
         kIndex++;
      }
      while(iIndex < n1) array[kIndex++] = leftArray[iIndex++];
      while(jIndex < n2) array[kIndex++] = rightArray[jIndex++];
      
      
   }
   static void MergeSort(int[] array, int left, int right){
      if(left < right){
         int mid = left + (right - left)/ 2;
         
         MergeSort(array, left, mid);
         MergeSort(array, mid + 1, right);
         
         Merge(array, left, mid, right);
      }
   }
   static void print(int[] array){
      
      for(int i  = 0; i < array.length; i++)
         System.out.print(i+" ");
      System.out.println();
      
   }
   public static void main(String... args){
   
   
      int[] arr = {2,1,3,4};
      int size = arr.length;
      
      print(arr);
      
      MergeSort(arr, 0, size - 1);
         
      print(arr);
      
      
   }
}
