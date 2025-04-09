import java.util.Scanner;

public class digit_query {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            long k = sc.nextLong();
            int length = 1;
            int count = 9;
            int start = 1;
            while (k >= length * count) {
                count = count * 10;
                start = start * 10;
                length++;
                k -= length * count;
            }
            long val = start + (k - 1) / length;
            char ele = Long.toString(val).charAt((int) ((k - 1) % length));
            System.out.println(ele);

        }

    }

}
