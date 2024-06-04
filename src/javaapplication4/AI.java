package javaapplication4;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import javax.swing.JButton;



//klasa zawierajaca gracza kontrolowanego przez komputer
public class AI {
    
    public void makeMove(JButton buttons[][], int[][] board, int turn)
    {
        int[] bestMove;
        if(turn==1)
        {
            bestMove=this.bestMoveMaximize(board);
        }
        else
        {
            bestMove=this.bestMoveMinimize(board);
        }
        int x=bestMove[0];
        int y=bestMove[1];
        buttons[x][y].doClick();
    }
    
    private int[] bestMoveMaximize(int[][] board)
    {
        //skopiuj plansze
        int[][] minimaxBoard=new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
               minimaxBoard[i][j]=board[i][j]; 
            }
        }
        
        int score;
        int bestScore=Integer.MIN_VALUE;
        int[] move={0,0};
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(minimaxBoard[i][j]==0)
                {
                    minimaxBoard[i][j]=1;
                    score=minimax(minimaxBoard,0,-1);
                    minimaxBoard[i][j]=0;
                    if(score>bestScore)
                    {
                        bestScore=score;
                        move[0]=i;
                        move[1]=j;
                    }
                }
            }
        }
        return(move);
    }
    
     private int[] bestMoveMinimize(int[][] board)
    {
        //skopiuj plansze
        int[][] minimaxBoard=new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
               minimaxBoard[i][j]=board[i][j]; 
            }
        }
        
        int score;
        int bestScore=Integer.MAX_VALUE;
        int[] move={0,0};
        
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(minimaxBoard[i][j]==0)
                {
                    minimaxBoard[i][j]=-1;
                    score=minimax(minimaxBoard,0,1);
                    minimaxBoard[i][j]=0;
                    if(score<bestScore)
                    {
                        bestScore=score;
                        move[0]=i;
                        move[1]=j;
                    }
                }
            }
        }
        return(move);
    }
    
    private int minimax(int [][] board, int depth, int turn)
    { 
        //skopiuj plansze
        int[][] minimaxBoard=new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
               minimaxBoard[i][j]=board[i][j]; 
            }
        }
       
        int result=TicTacToe.checkWin(minimaxBoard, -turn);
        if(result!=2)
        {
            //jesli doszlo do stanu koncowego gdzie jest remis lub ktos wygral
            return(10*result-result*depth);
        }
        
        if(turn==1)
        {
            int score;
            int bestScore=Integer.MIN_VALUE;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(minimaxBoard[i][j]==0)
                    {
                        minimaxBoard[i][j]=1;
                        score=minimax(minimaxBoard,depth+1,-1);
                        minimaxBoard[i][j]=0;
                        bestScore=max(score,bestScore);
                    }
                }
            }
            return(bestScore);
        }
        else
        {
            int score;
            int bestScore=Integer.MAX_VALUE;
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(minimaxBoard[i][j]==0)
                    {
                        minimaxBoard[i][j]=-1;
                        score=minimax(minimaxBoard,depth+1,1);
                        minimaxBoard[i][j]=0;
                        bestScore=min(score,bestScore);
                    }
                }
            }
            return(bestScore);
        }
    }  
}
