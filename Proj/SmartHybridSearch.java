public class SmartHybridSearch {

    static int tries = 0;

    public static int smartSearch(int[] arr, int target, int low, int high) {
        tries++;

        // If range is small, switch to linear search
        if (high - low <= 10) {
            for (int i = low; i <= high; i++) {
                tries++; // Count each linear try
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1; // Not found
        }

        // Otherwise, do recursive binary search
        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return smartSearch(arr, target, mid + 1, high);
        } else {
            return smartSearch(arr, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int target = 77;
        int low = 0;
        int high = arr.length - 1;

        long start = System.nanoTime();
        int result = smartSearch(arr, target, low, high);
        long end = System.nanoTime();

        System.out.println("Index: " + result);
        System.out.println("Tries: " + tries);
        System.out.println("Time taken (ns): " + (end - start));
    }
}
