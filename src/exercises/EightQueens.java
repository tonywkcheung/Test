package exercises;

public class EightQueens {
    
    public final int SIZE = 8;
    char[][] board = new char[SIZE][SIZE];
    public boolean isFinished = false;
    
    public void run() {
        initBoard();
        
        backtrack(0);        
    }
    
    public void backtrack(int i) {
        
        if (countTotal() == SIZE) {
            isFinished = true;
            printBoard();
        }
        else {
            for (int j=i; j<SIZE*SIZE; j++) {
                if (canMove(j)) {                    
                    makeMove(j);                               
                    backtrack(j+1);                   
                    if (isFinished) {
                        return;
                    }                  
                    undoMove(j);
                }
            }
        }         
    }

    private void initBoard() {
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                board[i][j] = '.';
            }
        }
    }

    private void printBoard() {
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private void makeMove(int i) {
        populateBoard(i, 'X');
    }

    private void undoMove(int i) {
        populateBoard(i, '.');
    }

    private void populateBoard(int i, char ch) {
        int x = i / SIZE;
        int y = i % SIZE;
        
        board[x][y] = ch;
    }

    private boolean canMove(int i) {

        int x = i / SIZE;
        int y = i % SIZE;
            
        if (countVertical(x) != 0) {
            return false;
        }
        if (countHorizontal(y) != 0) {
            return false;
        }
        if (countDiagonal1(x,y) != 0) {
            return false;
        }
        if (countDiagonal2(x,y) != 0) {
            return false;
        }
        return true;
    }

    private int countDiagonal1(int x, int y) {
        int count = 0;        

        int i=0, j=y-x;
        for (int z=0; z<SIZE; z++) {
            if (i>=0 && j>=0 && i<SIZE && j<SIZE) {
                if (board[i][j] == 'X') {
                    count++;
                }
            }    
            i++;
            j++;
        }
        return count;
    }

    private int countDiagonal2(int x, int y) {
        int count = 0;        

        int i=x+y, j=0;
        for (int z=0; z<SIZE; z++) {
            if (i>=0 && j>=0 && i<SIZE && j<SIZE){
                if (board[i][j] == 'X') {
                    count++;
                }
            }    
            i--;
            j++;
        }
        return count;
    }

    private int countHorizontal(int i) {
        int count = 0;
        
        for (int j=0; j<SIZE; j++) {
            if (board[j][i] == 'X') {
                count++;
            }
        }
        return count;
    }

    private int countVertical(int i) {
        int count = 0;
                
        for (int j=0; j<SIZE; j++) {
            if (board[i][j] == 'X') {
                count++;
            }
        }
        return count;
    }

    private int countTotal() {
        int count = 0;
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                if (board[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }    
}
