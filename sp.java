import java.io.*;

public class sp {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long X = Long.parseLong(input[0]);
            long Y = Long.parseLong(input[1]);

            long ans;
            if (Y > X) {
                ans = (Y - 1) * (Y - 1);
                ans += (Y % 2 != 0) ? X : (2 * Y - X);
            } else {
                ans = (X - 1) * (X - 1);
                ans += (X % 2 == 0) ? Y : (2 * X - Y);
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb.toString());
    }
}
