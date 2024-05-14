class Weight {
    private int[] data;

    // Constructor
    public Weight(int[] init) {
        data = new int[init.length];
        for (int j = 0; j < init.length; j++) {
            data[j] = init[j];
        }
    }

    // Calculate the average
    public int average() {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        // Integer division to compute the average
        return sum / data.length;
    }
}

public class Average {
    public static void main(String[] args) {
        int[] values = {98, 99, 98, 99, 100, 101, 102, 100, 104, 105,
            105, 106, 105, 103, 104, 103, 105, 106, 107, 106,
            105, 105, 104, 104, 103, 102, 102, 101, 100, 102};
        Weight june = new Weight(values);
        int avg = june.average();
        System.out.println("average = " + avg);
    }
}
