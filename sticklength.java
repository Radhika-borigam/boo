
import java.util.Arrays;
import java.util.Scanner;

public class sticklength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] sticks = new long[n];

        for (int i = 0; i < n; i++) {
            sticks[i] = sc.nextLong();
        }

        Arrays.sort(sticks);
        long median = sticks[n / 2];
        long cost = 0;

        for (long stick : sticks) {
            cost += Math.abs(stick - median);
        }

        System.out.println(cost);
        sc.close();
    }
}
