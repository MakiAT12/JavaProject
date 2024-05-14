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

    // Calculate the average for a range of days (inclusive)
    public int subAverage(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += data[i];
        }
        // Integer division to compute the average
        return sum / (end - start + 1); // Adding 1 to include the end day
    }
}

public class SubrangeOfDays {
    public static void main(String[] args) {
        int[] values = {98,  99,  98,  99, 100, 101, 102, 100, 104, 105,
            105, 106, 105, 103, 104, 103, 105, 106, 107, 106,
            105, 105, 104, 104, 103, 102, 102, 101, 100, 102};
        Weight june = new Weight(values);

        int totalDays = values.length;
        int firstHalfAverage = june.subAverage(0, totalDays / 2);
        int secondHalfAverage = june.subAverage(totalDays / 2, totalDays - 1);

        System.out.println("Average of the first half of the month: " + firstHalfAverage);
        System.out.println("Average of the second half of the month: " + secondHalfAverage);
        System.out.println("Difference: " + Math.abs(firstHalfAverage - secondHalfAverage));
    }
}
