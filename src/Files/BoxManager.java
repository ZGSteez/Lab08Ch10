package Files;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.util.*;

class BoxManager extends JPanel implements MouseListener {

    //private Ellipse2D;
    //private Line2D;
    //private Line2D;

	private ArrayList<Ellipse2D> circles = new ArrayList<>();
	private ArrayList<Line2D> lines = new ArrayList<Files.Line2D>();

    private Rectangle lastClicked;
    private Rectangle[][] matrix;
    private TurnManager.Item[][] token;
    private TurnManager turn;
    private ScreenInfo info;

    public BoxManager() {
        setLayout(null);
        info = new ScreenInfo();
        add(info.getLabel());

        info.createButton(token);
        info.getButton().setBounds(350, 40, 100, 30);
        add(info.getButton());
        info.getButton().setVisible(false);

        // matrix carries rectangle data
        // token carries data on whether a box was clicked or not
        // turn manages the current turn information
        matrix = new Rectangle[3][3];
        token = new TurnManager.Item[3][3];
        turn = new TurnManager();

        // default initialize variables
        addMouseListener(this);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] =
                        new Rectangle(i * 100, j * 100, 100, 100);
                token[i][j] = new TurnManager.Item();
            }
        }
    }

    /**
     * Interface implementation.
     */
    public void mouseClicked(MouseEvent mouse) {
        boolean clicked = false;

        // checks if reset button has been pressed
        if (info.getReset()) {

            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    token[i][j].active = false;

            turn.setTurn(false);
            info.setReset(false);
        }

        // checks if the mouse is within a box, then checks if the
        // box has been pressed before. Presses are also disabled
        // if a game has been won
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j].contains(mouse.getPoint())) {
                    if (turn.victory(token) == 0) {
                        if (!token[i][j].active) {
                            lastClicked = matrix[i][j];
                            token[i][j].active = true;
                            token[i][j].turn = turn.getTurn();
                            clicked = true;
                        }
                    }
                }
            }
        }
        if (clicked) {

            // displays the current turn and play
            if (turn.getTurn()) {
                System.out.println("Entered a 'x'");
                System.out.println(lastClicked);
                info.updateLabel(turn);
                lines.add(new Files.Line2D(lastClicked.x,lastClicked.y,lastClicked.width,lastClicked.height));
                Line2D newLine = (lines.get(lines.size()-1));
                System.out.println(lines.size());



            }
            if (!turn.getTurn()) {
                System.out.println("Entered a 'o'");
                System.out.println(lastClicked);
                info.updateLabel(turn);
				circles.add(new Files.Ellipse2D(lastClicked.x,lastClicked.y,lastClicked.width,lastClicked.height));
                Ellipse2D newCircle = (circles.get(circles.size()-1));
                System.out.println(circles.size());

			}

            int winState = turn.victory(token);
            // checks for player victory
            if (winState == 1) {
                info.updateLabel("Victory for X's");
                info.getButton().setVisible(true);
            }
            if (winState == 2) {
                info.updateLabel("Victory for O's");
                info.getButton().setVisible(true);
            }

            // checks for a player draw
            if (winState == 3) {
                info.updateLabel("Draw");
                info.getButton().setVisible(true);
            }

            // swap player turns
            turn.swapTurn();
        }
    }

    /**
     * Interface functions.
     */
    public void mouseExited(MouseEvent mouse) {
    }

    public void mouseReleased(MouseEvent mouse) {
    }

    public void mouseEntered(MouseEvent mouse) {
    }

    public void mousePressed(MouseEvent mouse) {
    }

    /**
     * Overload component graphics function.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g2.draw(matrix[i][j]);

            }
        }

//		g2.drawOval(100,100,100,100);
//		g2.fillOval(100,100,100,100);
//		g2.drawLine(0,0,100,100);
//		g2.drawLine(0,100,100,0);
    }


}