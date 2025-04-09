import java.util.*;

public class rest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<int[]> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrival = sc.nextInt();
            int leaving = sc.nextInt();
            events.add(new int[] { arrival, 1 }); // Customer arrives
            events.add(new int[] { leaving, -1 }); // Customer leaves
        }

        // Sort events: First by time, then by type (-1 before 1 if same time)
        events.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int maxCustomers = 0, currentCustomers = 0;

        for (int[] event : events) {
            currentCustomers += event[1];
            maxCustomers = Math.max(maxCustomers, currentCustomers);
        }

        System.out.println(maxCustomers);
        sc.close();
    }
}
