import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = n * (n + 1) / 2;
        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        if (n % 4 == 0) {
            for (int i = 1; i <= n / 2; i++) {
                if (i % 2 != 0) {
                    set1.add(i);
                    set1.add(n - i + 1);
                } else {
                    set2.add(i);
                    set2.add(n - i + 1);
                }
            }
        } else if (n % 4 == 3) {
            set1.add(1);
            set1.add(2);
            set2.add(3);
            for (int i = 4; i <= n; i++) {
                if ((i - 3) % 4 == 0 || (i - 3) % 4 == 1) {
                    set1.add(i);
                } else {
                    set2.add(i);
                }
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
    }
}
