import java.util.*;

public class cll {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();

            // Check conditions
            if ((a + b) % 3 == 0 && Math.min(a, b) * 2 >= Math.max(a, b)) {
                result.append("YES\n");
            } else {
                result.append("NO\n");
            }
        }

        System.out.print(result);
        sc.close();

    }
}
