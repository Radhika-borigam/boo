import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class two_set {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        sum = n * (n + 1) / 2;
        if (sum % 2 != 0) {
            System.out.println("NO");
        }
        System.out.println("YES");
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        long target = sum / 2;
        for (int i = n; i >= 1; i--) {
            if (i <= target) {
                set1.add(i);
                target -= i;
            } else {
                set2.add(i);
            }
        }

        System.out.println(set1.size());
        for (int num : set1) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println(set2.size());
        for (int num : set2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
