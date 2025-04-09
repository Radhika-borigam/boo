import java.util.*;

public class concertt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of tickets
        int m = sc.nextInt(); // Number of customers

        TreeMap<Integer, Integer> tickets = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int price = sc.nextInt();
            tickets.put(price, tickets.getOrDefault(price, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int maxPrice = sc.nextInt();

            // Find the highest ticket price that does not exceed maxPrice
            Map.Entry<Integer, Integer> entry = tickets.floorEntry(maxPrice);

            if (entry == null) {
                result.append("-1\n"); // No valid ticket found
            } else {
                result.append(entry.getKey()).append("\n");

                // Reduce count or remove if no more tickets of that price
                if (entry.getValue() == 1) {
                    tickets.remove(entry.getKey());
                } else {
                    tickets.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }

        System.out.print(result);
        sc.close();
    }
}
