import java.util.*;

public class playlist {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        int left = 0, max = 0;
        HashMap<Long, Integer> mp = new HashMap<>();

        for (int right = 0; right < n; right++) {
            mp.put(a[right], mp.getOrDefault(a[right], 0) + 1);

            // If duplicate found, shrink the window
            while (mp.get(a[right]) > 1) {
                mp.put(a[left], mp.get(a[left]) - 1);
                if (mp.get(a[left]) == 0) {
                    mp.remove(a[left]);
                }
                left++;
            }

            // Update max length
            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
        sc.close();
    }
}
