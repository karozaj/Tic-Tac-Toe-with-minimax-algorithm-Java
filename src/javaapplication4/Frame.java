package javaapplication4;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Frame extends JFrame implements ActionListener {

    private JButton[][] buttons=new JButton[3][3];
    private JLabel lab;
    private TicTacToe game;
    private AI opponent;
    
    public Frame(int turn)
    {
        this.game=new TicTacToe(turn);
        this.opponent=new AI();
        this.setUpFrame();
        if(game.getPlayerTurn()==1)
        {
            opponent.makeMove(buttons, game.getBoard(), -1);
            game.setTurn(1);
        }
        
    }
    
    private void setUpFrame()
    {
        //utworz okno gry
        this.setTitle("Kółko i krzyżyk");
        this.setSize(500,667);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4,3));
        this.setResizable(false);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                this.buttons[i][j]=new JButton();
                this.buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                //this.buttons[i][j].setText(String.valueOf(i)+String.valueOf(j));
                this.buttons[i][j].addActionListener(this);
                this.add(buttons[i][j]);
            }
        }
    
        lab=new JLabel();
        lab.setFont(new Font("Arial", Font.PLAIN, 25));
        lab.setText("Kółko i krzyżyk");
        this.add(lab);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //sprawdz czy gra sie zakonczyla, jesli nie to dodaj znak na plansze i sprawdz czy ktos wygral
        //jesli ktos wygral lub jest remis to zmien informacje w oknie
        if(game.isGameOver()==false)
        {
        
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(e.getSource().equals(buttons[i][j]))
                    {
                        if(game.getTurn()==-1)
                        {
                            buttons[i][j].setText("X");
                            game.setBoard(i,j,-1);
                            int winInfo=TicTacToe.checkWin(game.getBoard(),game.getTurn());
                            if (winInfo==-1)
                            {
                                game.setGameOver(true);
                                lab.setText("Wygrywa X!");
                            }
                            else if(winInfo==0)
                            {
                                game.setGameOver(true);
                                lab.setText("Remis!");
                            }
                            game.setTurn(1);
                            if(game.getPlayerTurn()==-1){
                                opponent.makeMove(this.buttons, game.getBoard(),1);}
                        }
                        else if(game.getTurn()==1)
                        {
                            buttons[i][j].setText("O");
                            game.setBoard(i,j,1);
                            int winInfo=TicTacToe.checkWin(game.getBoard(),game.getTurn());
                            if (winInfo==1)
                            {
                                game.setGameOver(true);
                                lab.setText("Wygrywa O!");
                            }
                            else if(winInfo==0)
                            {
                                game.setGameOver(true);
                                lab.setText("Remis!");
                            }
                            game.setTurn(-1);
                            if(game.getPlayerTurn()==1){
                            opponent.makeMove(this.buttons, game.getBoard(),-1);}
                        }
                        buttons[i][j].setEnabled(false);
                    }
                }
            }
        }
    }
    
}
