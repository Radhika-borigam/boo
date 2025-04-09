import java.util.*;

public class collecting {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = i;
        }
        int count = 1;
        Arrays.sort(a, (b, c) -> b[0] - c[0]);
        for (int i = 1; i < n; i++) {
            int num1[] = a[i - 1];
            int num[] = a[i];
            if (num1[1] > num[1]) {
                count++;
            }
        }
        System.out.println(count);

    }
}
