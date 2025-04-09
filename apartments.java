import java.util.*;

public class apartments {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Read input
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] apli = new int[n]; // Applicants' desired sizes
        for (int i = 0; i < n; i++) {
            apli[i] = sc.nextInt();
        }

        int[] app = new int[m]; // Apartment sizes
        for (int i = 0; i < m; i++) {
            app[i] = sc.nextInt();
        }

        // Sort both arrays
        Arrays.sort(apli);
        Arrays.sort(app);

        int i = 0, j = 0, count = 0;

        // Two-pointer approach
        while (i < n && j < m) {
            if (Math.abs(apli[i] - app[j]) <= k) {
                // Apartment allocated
                count++;
                i++;
                j++;
            } else if (app[j] < apli[i] - k) {
                // Apartment too small, move to next apartment
                j++;
            } else {
                // Applicant cannot be satisfied, move to next applicant
                i++;
            }
        }

        // Print the result
        System.out.println(count);

        sc.close(); // Close the scanner
    }
}
