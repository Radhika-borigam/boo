import java.util.HashSet;
import java.util.Scanner;

public class distinct {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt()); // HashSet stores only distinct elements
        }
        System.out.println(set.size()); // Number of distinct elements
    }
}
