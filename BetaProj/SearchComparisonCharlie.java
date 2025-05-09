import java.util.Scanner;
public class SearchComparisonCharlie {

    static int triesBinary = 0;
    static int triesHybrid = 0;

    public static int binarySearch(int[] arr, int target, int low, int high) {
        triesBinary++;
        if (low > high) return -1;
        int mid = (low + high) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, high);
        else return binarySearch(arr, target, low, mid - 1);
    }

    public static int hybridSearch(int[] arr, int target, int low, int high) {
        triesHybrid++;

            int left = target - arr[low];
            int right = arr[high] - target;

            if(arr[high] < target || arr[low] > target)
                return -1;  

            
            if(left <= 10 && left < right) {
                for (int i = low; i <= high; i++) 
                    if (arr[i] == target) return i;
            } 
            else if (right <= 10 && right < left) {
                for (int i = high; i >= low; i--) 
                    if (arr[i] == target) return i;
            }

            if (high - low <= 10) {
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (arr[mid] == target) return mid;
                    else if (arr[mid] < target) low = mid + 1;
                    else high = mid - 1;
                }
                return -1;
            }

        int mid = (low + high) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return hybridSearch(arr, target, mid + 1, high);
        else return hybridSearch(arr, target, low, mid - 1);
    }

    public static void test(int[] arr, int target) {
        triesBinary = 0;
        triesHybrid = 0;

        long startBin = System.nanoTime();
        int resultBin = binarySearch(arr, target, 0, arr.length - 1);
        long endBin = System.nanoTime();

        long startHy = System.nanoTime();
        int resultHy = hybridSearch(arr, target, 0, arr.length - 1);
        long endHy = System.nanoTime();

        System.out.println("== Target: " + target + " ==");
        System.out.println("Binary Search: Index = " + resultBin + ", Tries = " + triesBinary + ", Time (ns) = " + (endBin - startBin));
        System.out.println("Hybrid Search: Index = " + resultHy + ", Tries = " + triesHybrid + ", Time (ns) = " + (endHy - startHy));
        System.out.println();
    }
    public static void main(String[] args) {
        int target = 1; // Initialize target variable to avoid compilation error
        int[] arr = new int[1_000_000];
        
        // Test array of 1_000_000 elements
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;
        
        Scanner scan = new Scanner(System.in);
        while(target > 0) {
            System.out.print("Enter a target value (1 - 1,000,000): ");
            target = scan.nextInt(); // Read target value from user input
            test(arr, target);
        }
    }
}