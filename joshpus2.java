import java.util.*;

public class joshpus2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while (!q.isEmpty()) {
            long rotations = k % q.size();
            for (int i = 1; i <= rotations; i++) {
                q.offerLast(q.pollFirst());
            }
            System.out.print(q.pollFirst() + " ");
        }
    }

}
