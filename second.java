import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after the integer input

        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            System.out.println(maximizeString(s));
        }
    }

    private static String maximizeString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 1; i < n; i++) {
            if (chars[i] > '0' && chars[i] > chars[i - 1]) {
                // Decrease the current character by 1
                chars[i]--;
                // Swap with the previous character
                char temp = chars[i];
                chars[i] = chars[i - 1];
                chars[i - 1] = temp;
                // Reset i to 1 to recheck the string from the beginning
                i = 0;
            }
        }

        return new String(chars);
    }
}