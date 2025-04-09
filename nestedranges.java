import java.io.*;
import java.util.*;

public class nestedranges {
    static class Range {
        int l, r, idx;

        Range(int l, int r, int idx) {
            this.l = l;
            this.r = r;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        // Use BufferedReader for fast I/O.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Range[] ranges = new Range[n];

        // Read input intervals.
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            int l = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);
            ranges[i] = new Range(l, r, i);
        }

        // For both questions we use the same sorting: left ascending,
        // and if left endpoints are equal, sort by right descending.
        Range[] sorted = ranges.clone();
        Arrays.sort(sorted, new Comparator<Range>() {
            public int compare(Range a, Range b) {
                if (a.l == b.l)
                    return b.r - a.r;
                return a.l - b.l;
            }
        });

        // Contains array: for each original interval, 1 if it contains another
        // interval.
        int[] contains = new int[n];
        // minRight array to store the minimum right endpoint among intervals after
        // current.
        int[] minRight = new int[n];
        minRight[n - 1] = sorted[n - 1].r;
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(sorted[i].r, minRight[i + 1]);
        }
        // Check if an interval contains some other range.
        // (For the last interval there is no later interval to compare.)
        for (int i = 0; i < n - 1; i++) {
            if (minRight[i + 1] <= sorted[i].r) {
                contains[sorted[i].idx] = 1;
            }
        }

        // IsContained array: for each original interval, 1 if it is contained in some
        // other interval.
        int[] isContained = new int[n];
        int currentMax = -1;
        // Traverse sorted intervals from left to right.
        // Every interval before the current one has l <= current.l.
        for (int i = 0; i < n; i++) {
            Range cur = sorted[i];
            if (currentMax >= cur.r) {
                isContained[cur.idx] = 1;
            }
            currentMax = Math.max(currentMax, cur.r);
        }

        // Build output lines in the original order.
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb1.append(contains[i]);
            if (i < n - 1)
                sb1.append(" ");
        }
        for (int i = 0; i < n; i++) {
            sb2.append(isContained[i]);
            if (i < n - 1)
                sb2.append(" ");
        }

        // Print the results.
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
    }
}
