
import java.util.*;

public class cs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = str.length();
        boolean ar[] = new boolean[n];
        Set<String> res = new HashSet<>();

        finding(str, n, ar, new StringBuilder(), res);
        List<String> sortedRes = new ArrayList<>(res);
        Collections.sort(sortedRes);
        System.out.println(res.size());
        for (String ss : sortedRes) {
            System.out.println(ss);
        }
        sc.close();
    }

    static void finding(String str, int n, boolean ar[], StringBuilder s, Set<String> res) {
        if (s.length() == n) {
            res.add(s.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!ar[i]) {
                s.append(str.charAt(i));
                ar[i] = true;
                finding(str, n, ar, s, res);
                s.deleteCharAt(s.length() - 1);
                ar[i] = false;
            }
        }
    }

}
