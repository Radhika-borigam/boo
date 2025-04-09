
import java.util.*;

public class josh2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.add(queue.poll()); // Move the first element to the back
            System.out.print(queue.poll() + " "); // Remove and print every second element
        }

        System.out.print(queue.peek()); // Last survivor
    }
}
