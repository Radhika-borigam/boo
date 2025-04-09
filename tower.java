import java.util.Scanner;

public class tower {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // Print the minimum number of moves
        System.out.println((int) Math.pow(2, n) - 1);

        // Solve the Tower of Hanoi
        towerOfHanoi(n, 1, 3, 2);
    }

    // Recursive method to solve Tower of Hanoi
    static void towerOfHanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            System.out.println(from + " " + to);
            return;
        }
        // Move top n-1 disks from source to auxiliary
        towerOfHanoi(n - 1, from, aux, to);

        // Move the nth disk from source to target
        System.out.println(from + " " + to);

        // Move n-1 disks from auxiliary to target
        towerOfHanoi(n - 1, aux, to, from);
    }
}
