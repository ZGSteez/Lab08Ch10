import javax.swing.JFrame;
public class TicTacToe {

    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 1200;

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

//Implement a program that allows two players to play
//tic-tac-toe. Draw the game grid and an indication of
//whose turn it is (X or O). Upon the next click, check that
//the mouse click falls into an empty location, fill the
//location with the mark of the current player, and give the
//other player a turn. If the game is won, indicate the
//winner. Also supply a button for starting over.