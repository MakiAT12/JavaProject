public class BinarySearch {

    static int tries = 0;

    public static int binarySearch(int[] arr, int target, int low, int high) {
        tries++;

        if (low > high) {
            return -1; // Not found
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, high);
        } else {
            return binarySearch(arr, target, low, mid - 1);
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
        int result = binarySearch(arr, target, low, high);
        long end = System.nanoTime();

        System.out.println("Index: " + result);
        System.out.println("Tries: " + tries);
        System.out.println("Time taken (ns): " + (end - start));
    }
}
