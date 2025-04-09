import java.util.Scanner;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            long val = sc.nextLong();
            currentSum = Math.max(val, currentSum + val);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
        sc.close();
    }
}
