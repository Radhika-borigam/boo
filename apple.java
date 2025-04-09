import java.util.Scanner;

public class apple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            totalSum += arr[i];
        }

        long minDiff = Long.MAX_VALUE;
        for (int mask = 0; mask < (1 << n); mask++) {
            long subsetSum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsetSum += arr[i];
                }
            }
            long otherSubsetSum = totalSum - subsetSum;
            long diff = Math.abs(subsetSum - otherSubsetSum);
            minDiff = Math.min(minDiff, diff);
        }

        System.out.println(minDiff);
        sc.close();
    }
}
