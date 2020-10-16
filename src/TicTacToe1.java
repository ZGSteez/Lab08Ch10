import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe1 implements ActionListener {
    private JButton tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, resetButton;
    private JFrame f = new JFrame();
    private JLabel turnMessage;
    private Boolean xTurn = false;
    private Boolean oTurn = false;
    private final int RANGE = 10;
    private JLabel winnerMessage;
    private final int HEIGHT = 900, WIDTH = 1200;

    public TicTacToe1() {
        createGUI(f);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void createGUI(JFrame f) {
        Random random = new Random();

        int randomNum = random.nextInt(RANGE) + 1;

        if (randomNum >= 6) {
            xTurn = true;
        } else {
            oTurn = true;
        }

        if (xTurn == true) {
            turnMessage = new JLabel("It is X's turn");
        } else {
            turnMessage = new JLabel("It is O's turn");

        }
        turnMessage.setBounds(1050, 600, 100, 50);


        tile1 = new JButton("Z");
        tile1.setBounds(0, 0, 300, 300);
        tile1.addActionListener(this);

        tile2 = new JButton("Z");
        tile2.setBounds(300, 0, 300, 300);
        tile2.addActionListener(this);

        tile3 = new JButton("Z");
        tile3.setBounds(600, 0, 300, 300);
        tile3.addActionListener(this);

        tile4 = new JButton("Z");
        tile4.setBounds(0, 300, 300, 300);
        tile4.addActionListener(this);

        tile5 = new JButton("Z");
        tile5.setBounds(300, 300, 300, 300);
        tile5.addActionListener(this);

        tile6 = new JButton("Z");
        tile6.setBounds(600, 300, 300, 300);
        tile6.addActionListener(this);

        tile7 = new JButton("Z");
        tile7.setBounds(0, 600, 300, 300);
        tile7.addActionListener(this);

        tile8 = new JButton("Z");
        tile8.setBounds(300, 600, 300, 300);

        tile9 = new JButton("Z");
        tile9.setBounds(600, 600, 300, 300);
        tile9.addActionListener(this);


        resetButton = new JButton("Reset");
        resetButton.setBounds(1050, 800, 100, 50);

        f.add(tile1);
        f.add(tile2);
        f.add(tile3);
        f.add(tile4);
        f.add(tile5);
        f.add(tile6);
        f.add(tile7);
        f.add(tile8);
        f.add(tile9);
        f.add(turnMessage);
        f.add(resetButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            System.out.print("You pressed the reset Button");
        }
        else if (e.getSource() == tile1) {
            if (xTurn == true) {
                turnMessage = new JLabel("It is O's turn");
            } else if (oTurn == true) {
                turnMessage = new JLabel("It is X's turn");
            }
            f.add(turnMessage);


        } else if (e.getSource() == tile2) {

        } else if (e.getSource() == tile3) {

        } else if (e.getSource() == tile4) {

        } else if (e.getSource() == tile5) {

        } else if (e.getSource() == tile6) {

        } else if (e.getSource() == tile8) {

        } else if (e.getSource() == tile8) {

        } else if (e.getSource() == tile9) {

        }

    }

}
