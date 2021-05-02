package leetcode;
public class NQueenProblem { 
    final int N = 4; 
    int totalSolutions = 0;
  
    /* A utility function to print solution */
    void printSolution(int board[][]) 
    { 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
    } 
  
    boolean isSafe(int board[][], int row, int col) 
    { 
        int i, j; 
  
        for (i = 0; i < row; i++) 
            if (board[i][col] == 1) 
                return false; 
  
        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) 
                return false; 
        
        /* Check upper diagonal on right side */
        for (i = row, j = col; i >= 0 && j < N; i--, j++) 
            if (board[i][j] == 1) 
                return false; 
  
        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        return true; 
    } 
  
    
    boolean solveNQUtil(int board[][], int row) 
    {
        if (row >= N) {
        	totalSolutions++;
        	//printSolution(board);
        	//System.out.println();
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) { 
                board[row][i] = 1; 
  
                if (solveNQUtil(board, row + 1)) 
                    return true; 
  
                board[row][i] = 0; // BACKTRACK 
            } 
        }
        return false; 
    } 
  
    
    boolean solveNQ() 
    { 
        /*int board[][] = { { 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0 },
                          { 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          { 0, 0, 0, 0, 0, 0, 0, 0 } }; */
        
        int board[][] = new int[N][N];
        for(int i=0; i<N;i++) {
        	for(int j=0; j<N;j++) {
        		board[i][j] = 0;
        	}
        }
  
        solveNQUtil(board, 0);
  
        System.out.println(totalSolutions);
        return true; 
    } 
  
    // driver program to test above function 
    public static void main(String args[]) 
    { 
        NQueenProblem Queen = new NQueenProblem(); 
        Queen.solveNQ(); 
    } 
} 
