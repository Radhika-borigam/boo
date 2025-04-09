import java.util.*;

public class ferris {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        long w[] = new long[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextLong(); // Read as long
        }
        Arrays.sort(w);
        int count = 0;
        int l = 0;
        int r = w.length - 1;
        while (l < r) {
            if (w[r] + w[l] <= x) {
                count++;
                l++;
                r--;
            } else if (w[r] + w[l] > x) {
                r--;
            } else {
                l++;
            }

        }
        long val = n - count;
        System.out.println(val);
    }
}
