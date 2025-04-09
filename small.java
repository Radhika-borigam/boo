import java.util.*;

public class small {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        long smallestone = 1;
        Arrays.sort(a);
        for (long num : a) {
            if (smallestone < num) {
                break;
            }
            smallestone += num;
        }
        System.out.println(smallestone);

    }

}
