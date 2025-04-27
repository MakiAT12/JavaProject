public class A_SearchComparison {

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
        int[] arr = new int[1_000_000];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;

        test(arr, 1);                // First element
        test(arr, 500_000);          // Middle
        test(arr, 750_000);          // Middle Right
        test(arr, 999_999);          // Near end
        test(arr, 1_000_001);        // Not found
    }
}