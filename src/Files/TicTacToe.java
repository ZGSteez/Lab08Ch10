package Files;

import javax.swing.JFrame;

public class TicTacToe {

	private static final int FRAME_WIDTH = 600;
	private static final int FRAME_HEIGHT = 600;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        frame.add(new BoxManager());

        frame.setVisible(true);
    }
}