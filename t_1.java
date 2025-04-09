import java.util.*;

public class t_1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        Map<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            hp.put(a[i], hp.getOrDefault(a[i], 0) + 1);
        }
        System.out.println(hp.size());
    }

}
