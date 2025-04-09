import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class two_knight {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (long k = 1; k <= n; k++) {
            long totalWays = (k * k * (k * k - 1)) / 2;
            long attackingWays = 4 * (k - 1) * (k - 2);
            sb.append(totalWays - attackingWays).append("\n");
        }

        System.out.print(sb);

    }

}
