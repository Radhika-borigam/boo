import java.util.*;

public class bt {
    public static void main(String args[]) {
        int mod = 1000000007; // 10^9 + 7
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(modularExponentiation(2, n, mod));
    }

    public static long modularExponentiation(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp = exp / 2;
        }
        return result;
    }
}
