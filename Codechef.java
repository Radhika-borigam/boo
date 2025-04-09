import java.util.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int res = 0;
            Map<Integer, Integer> mp = new HashMap<>();
            for (int num : a) {
                mp.put(num, mp.getOrDefault(num, 0) + 1);
            }
            Map<Integer, Integer> tempMap = new HashMap<>(mp);
            for (Map.Entry<Integer, Integer> p : mp.entrySet()) {
                int val = p.getKey();
                int freq = p.getValue();
                if (val == 0)
                    continue;
                if (freq > 1) {
                    tempMap.put(0, tempMap.getOrDefault(0, 0) + freq / 2);
                    tempMap.put(val, freq % 2);
                }
            }
            mp = tempMap;

            System.out.println(mp);

            for (Map.Entry<Integer, Integer> p : mp.entrySet()) {
                if (p.getKey() == 0) {
                    res++;
                } else {
                    res += p.getValue();
                }
            }
            System.out.println(res);
        }
    }
}
