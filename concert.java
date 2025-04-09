import java.util.*;

public class Concert {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Input number of tickets and customers
        int n = sc.nextInt();
        int m = sc.nextInt();

        // Input ticket prices
        int[] tickets = new int[n];
        for (int i = 0; i < n; i++) {
            tickets[i] = sc.nextInt();
        }

        // Input customers' maximum prices
        int[] customers = new int[m];
        for (int i = 0; i < m; i++) {
            customers[i] = sc.nextInt();
        }

        // Use a TreeSet to manage available ticket prices
        TreeSet<Integer> availableTickets = new TreeSet<>();

        // Add all ticket prices into the TreeSet
        for (int price : tickets) {
            availableTickets.add(price);
        }

        // Process each customer
        for (int i = 0; i < m; i++) {
            int maxPrice = customers[i];

            // Find the highest ticket price that is less than or equal to maxPrice
            Integer chosenTicket = availableTickets.floor(maxPrice);
            if (chosenTicket != null) {
                System.out.println(chosenTicket);
                availableTickets.remove(chosenTicket); // Remove the ticket after it's purchased
            } else {
                System.out.println("-1"); // No available ticket for this customer
            }
        }
    }
}
