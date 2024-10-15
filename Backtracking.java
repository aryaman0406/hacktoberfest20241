public class NQueens {
    // Function to check if a queen can be placed at board[row][col]
    public static boolean isSafe(int board[][], int row, int col, int N) {
        // Check this row on the left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check the upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check the lower diagonal on the left side
        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Function to solve N-Queens problem using backtracking
    public static boolean solveNQueens(int board[][], int col, int N) {
        // If all queens are placed, return true
        if (col >= N)
            return true;

        // Try placing queens in all rows one by one for this column
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                // Place the queen at board[i][col]
                board[i][col] = 1;

                // Recur to place queens in the next column
                if (solveNQueens(board, col + 1, N))
                    return true;

                // If placing the queen at board[i][col] doesn't lead to a solution, backtrack
                board[i][col] = 0;
            }
        }

        // If no queen can be placed in this column, return false
        return false;
    }

    // Function to print the board
    public static void printSolution(int board[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
        int N = 4; // Size of the chessboard (4x4 in this example)
        int[][] board = new int[N][N]; // Chessboard initialized with zeros (no queens placed)

        if (!solveNQueens(board, 0, N)) {
            System.out.println("Solution does not exist.");
        } else {
            printSolution(board, N);
        }
    }
}
