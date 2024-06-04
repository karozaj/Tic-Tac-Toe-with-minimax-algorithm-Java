package javaapplication4;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChoiceWindow extends JFrame implements ActionListener {

    private final JButton crossButton;
    private final JButton circleButton;
    private final JLabel lab;
    
    public ChoiceWindow()
    {
        //utworz okno, gdzie gracz wybierze czy zagra kolkiem czy krzyzykiem
        crossButton=new JButton("X");
        crossButton.addActionListener(this);
        circleButton=new JButton("O");
        circleButton.addActionListener(this);
        lab=new JLabel("Wybierz swoją figurę.");
        
        this.setTitle("Wybierz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250,100);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.add(lab);
        this.add(crossButton);
        this.add(circleButton);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(crossButton))
        {
            Frame frame=new Frame(-1);
            this.dispose();
        }
        if(e.getSource().equals(circleButton))
        {
            Frame frame=new Frame(1);
            this.dispose();
        }
        
    }
    
}
