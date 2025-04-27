public class A_SmartHybridSearch {

    static int tries = 0;

    public static int smartSearch(int[] arr, int target, int low, int high) {
        tries++;

        // If range is small, use divide-and-conquer linear-style search
        if (high - low <= 10) {
            return divideAndConquerSearch(arr, target, low, high);
        }

        // Binary search as usual
        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return smartSearch(arr, target, mid + 1, high);
        } else {
            return smartSearch(arr, target, low, mid - 1);
        }
    }

    // Divide and Conquer Linear Search
    public static int divideAndConquerSearch(int[] arr, int target, int low, int high) {
        tries++; // Count this call as a try

        if (low > high) {
            return -1;
        }

        if (low == high) {
            tries++;
            return arr[low] == target ? low : -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        int left = divideAndConquerSearch(arr, target, low, mid - 1);
        if (left != -1) return left;

        return divideAndConquerSearch(arr, target, mid + 1, high);
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
