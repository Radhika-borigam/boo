import java.util.*;

public class palin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character, Integer> mp = new HashMap<>();

        // Count frequency of each character
        for (char ch : str.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int oddCount = 0;
        char oddChar = ' ';
        StringBuilder firstHalf = new StringBuilder();

        // Build the first half of the palindrome
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            int count = entry.getValue();
            char c = entry.getKey();

            // Check if the character count is odd
            if (count % 2 != 0) {
                oddCount++;
                oddChar = c;
                if (oddCount > 1) {
                    System.out.println("NO SOLUTION");
                    sc.close();
                    return;
                }
            }

            // Add half of the characters to the first half
            for (int i = 0; i < count / 2; i++) {
                firstHalf.append(c);
            }
        }

        // Construct the palindrome
        StringBuilder palindrome = new StringBuilder(firstHalf);
        if (oddCount == 1) {
            palindrome.append(oddChar);
        }
        palindrome.append(firstHalf.reverse());

        // Print the palindrome
        System.out.println(palindrome);
        sc.close();
    }
}
