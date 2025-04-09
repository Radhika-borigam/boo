import java.util.*;

public class creating_string {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        boolean ar[] = new boolean[n];
        finding(str, n, ar, new StringBuilder());
    }

    static void finding(String str, int n, boolean ar[], StringBuilder s) {
        if (s.length() == n) {
            System.out.println(s);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!ar[i]) {
                s.append(str.charAt(i));
                ar[i] = true;
                finding(str, n, ar, s);
                s.deleteCharAt(s.length() - 1);
                ar[i] = false;
            }
        }
    }

}
