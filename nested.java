import java.util.Arrays;
import java.util.Scanner;

public class nested {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ar[][] = new int[n][2];

        // Input values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                ar[i][j] = sc.nextInt();
            }
        }
        int[][] sortedByFirst = Arrays.copyOf(ar, ar.length);
        int[][] sortedBySecond = Arrays.copyOf(ar, ar.length);
        Arrays.sort(sortedByFirst, (a, b) -> (b[0] != a[0]) ? (b[0] - a[0]) : (a[1] - b[1]));
        Arrays.sort(sortedBySecond, (a, b) -> a[1] - b[1]);
        System.out.println("Sorted by first column (descending), second column (ascending):");
        for (int i = 0; i < n; i++) {
            System.out.println(sortedByFirst[i][0] + " " + sortedByFirst[i][1]);
        }
        System.out.println("Sorted by second column (ascending):");
        for (int i = 0; i < n; i++) {
            System.out.println(sortedBySecond[i][0] + " " + sortedBySecond[i][1]);
        }

        sc.close();
    }
}
