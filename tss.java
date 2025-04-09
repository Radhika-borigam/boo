import java.util.Scanner;
import java.util.*;

public class tss {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int ans[] = new int[2];
        Arrays.fill(ans, -1);
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (mp.containsKey((x - val))) {
                ans[0] = mp.get((x - val)) + 1;
                ans[1] = i + 1;
            }
            mp.put(val, i);
        }
        if (ans[0] != -1 || ans[1] != -1) {
            System.out.println(ans[0] + " " + ans[1]);
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }

}
