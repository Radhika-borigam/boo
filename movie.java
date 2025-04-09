import java.util.*;

public class movie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] movies = new int[n][2];

        // Read movie start and end times.
        for (int i = 0; i < n; i++) {
            movies[i][0] = sc.nextInt(); // start time
            movies[i][1] = sc.nextInt(); // end time
        }

        // Sort movies by their end times.
        Arrays.sort(movies, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0; // To count the maximum number of movies
        int prevEnd = 0; // End time of the last selected movie

        // Iterate over movies and select those that don't overlap.
        for (int i = 0; i < n; i++) {
            if (movies[i][0] >= prevEnd) {
                count++;
                prevEnd = movies[i][1];
            }
        }

        System.out.println(count);
        sc.close();
    }
}
