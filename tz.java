import java.util.Scanner;

public class tz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;

        // Count factors of 5
        for (int i = 5; i <= n; i *= 5) {
            ans += n / i;
        }

        System.out.println(ans);
    }
}
