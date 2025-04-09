import java.util.*;

public class f1 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            int n = s1.length();
            char ch[] = s1.toCharArray();
            for (int i = 0; i < n; i++) {
                if (ch[i] > '0' && ch[i] > ch[i - 1]) {
                    ch[i]--;
                    char t = ch[i];
                    ch[i] = ch[i - 1];
                    ch[i - 1] = t;
                    if (i > 1) {
                        i = -2;
                    }
                }
            }
            System.out.println(ch);
        }

    }

}
