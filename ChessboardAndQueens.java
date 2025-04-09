public class ChessboardAndQueens {

    private static int count = 0;

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // Reading the board input
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = sc.next().toCharArray();
        }

        // Arrays to track columns and diagonals under attack
        boolean[] column = new boolean[8];
        boolean[] diag1 = new boolean[15]; // diag1[i] is for (r - c + 7)
        boolean[] diag2 = new boolean[15]; // diag2[i] is for (r + c)

        // Start placing queens from the first row
        placeQueens(board, 0, column, diag1, diag2);

        // Print the result
        System.out.println(count);
    }

    public static void placeQueens(char[][] board, int row, boolean[] column, boolean[] diag1, boolean[] diag2) {
        // If all queens are placed, increment the count
        if (row == 8) {
            count++;
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < 8; col++) {
            if (board[row][col] == '.' && !column[col] && !diag1[row - col + 7] && !diag2[row + col]) {
                // Place the queen
                column[col] = true;
                diag1[row - col + 7] = true;
                diag2[row + col] = true;

                // Recur to place the next queen
                placeQueens(board, row + 1, column, diag1, diag2);

                // Backtrack
                column[col] = false;
                diag1[row - col + 7] = false;
                diag2[row + col] = false;
            }
        }
    }
}
