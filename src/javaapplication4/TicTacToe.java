package javaapplication4;

public class TicTacToe {
    private int[][] board=new int[3][3];
    private int turn;
    private int playerTurn;
    private boolean gameOver;
    
    public TicTacToe(int turn)
    {
        //stworz plansze i ustal stan gry
        playerTurn=turn;
        this.turn=-1;
        gameOver=false;
        
         for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=0;
            }
        }
    }
    
     public static int checkWin(int[][] board, int turn)
    {
        //sprawdz czy ktos wygral lub czy jest remis i jesli tak to zakoncz gre
        //sprawdz wiersze
        for(int i=0;i<3;i++)
        {
            if((board[i][0]+board[i][1]+board[i][2])==(3*turn))
            {
                return(turn);
            }
        }
        
        //sprawdz kolumny
        for(int i=0;i<3;i++)
        {
            if((board[0][i]+board[1][i]+board[2][i])==(3*turn))
            {
                return(turn);
            }
        }
        
        //sprawdz przekatne
        if((board[0][0]+board[1][1]+board[2][2])==(3*turn))
        {
            return(turn);
        }
        if((board[0][2]+board[1][1]+board[2][0])==(3*turn))
        {
            return(turn);
        }
        
        //sprawdz czy remis
        if(TicTacToe.checkTie(board)==true)
        {
            return(0);
        }
        //2 oznacza brak wygranej lub remisu
        return 2;
    }
    
    private static boolean checkTie(int[][] board)
    {
        //sprawdz czy remis
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==0)
                {
                    return(false);
                }
            }
        }
        return(true);
    }

    public int[][] getBoard() {
        return board;
    }

    public int getTurn() {
        return turn;
    }

    public void setBoard(int i,int j,int val) {
        //Zmodyfikuj plansze po ruchu gracza
        this.board[i][j] =val;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean isGameOver() {
        return gameOver;
    }
    
    public void setGameOver(boolean gameOver) {
        this.gameOver=gameOver;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }
    
    
    
}
