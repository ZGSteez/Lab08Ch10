import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class BoxManager extends JPanel implements MouseListener {

    private Rectangle box = new Rectangle(0, 0, 100, 100);
    private Rectangle box2 = new Rectangle(100, 0, 100, 100);
    private Rectangle box3 = new Rectangle(200, 0, 100, 100);
    private Rectangle box4 = new Rectangle(0, 100, 100, 100);
    private Rectangle box5 = new Rectangle(100, 100, 100, 100);
    private Rectangle box6 = new Rectangle(200, 100, 100, 100);
    private Rectangle box7 = new Rectangle(0, 200, 100, 100);
    private Rectangle box8 = new Rectangle(100, 200, 100, 100);
    private Rectangle box9 = new Rectangle(200, 200, 100, 100);
    private Rectangle lastClicked;
    private ArrayList<Rectangle> clickedBoxes = new ArrayList<>();
    private boolean exitScreen = true;
    private boolean oTurn = false;
    private boolean xTurn = false;
    private boolean lastClickedFlag = false;

    private String X_MESSAGE = "It is X's turn";
    private String O_MESSAGE = "It is O's turn";

    private Graphics2D g2;

    private JLabel turnMessage;
    JLabel image1 = new JLabel();
    JLabel image2 = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton reset = new JButton();



    public BoxManager() {
        setTurn();
        setImages();
        createMenu();
        addMouseListener(this);
    }

    public void createMenu(){
        turnMessage = new JLabel(message());
        turnMessage.setBounds(400,400,50,50);
        add(turnMessage);
        reset = new JButton("Reset");
        reset.setBounds(350,600,50,50);
        add(reset);
    }



    public String message(){
        String returnStatement = "";
        if (xTurn == true){
            returnStatement = X_MESSAGE;
        }
        else if (oTurn == true){
            returnStatement = O_MESSAGE;
        }
        return returnStatement;
    }


    public void setTurn() {
        Random random = new Random();

        int randomNum = random.nextInt(1);

        if (randomNum == 0) {
            oTurn = true;
        } else {
            xTurn = true;
        }
    }

    /**
     * Interface implementation.
     */
    public void mouseClicked(MouseEvent mouse) {
        if (box.contains(mouse.getPoint()) && !clickedBoxes.contains(box) && exitScreen) {
            System.out.println("Clicked on box1");
            lastClicked = box;
            exitScreen = false;
            clickedBoxes.add(lastClicked);
        } else if (box2.contains(mouse.getPoint()) && !clickedBoxes.contains(box2) && exitScreen) {
            System.out.println("Clicked on box2");
            lastClicked = box2;
            exitScreen = false;
            clickedBoxes.add(lastClicked);
        } else if (box3.contains(mouse.getPoint()) && !clickedBoxes.contains(box3) && exitScreen) {
            System.out.println("Clicked on box3");
            lastClicked = box3;
            exitScreen = false;
            clickedBoxes.add(lastClicked);
        } else if (box4.contains(mouse.getPoint()) && !clickedBoxes.contains(box4) && exitScreen) {
            System.out.println("Clicked on box4");
            lastClicked = box4;
            exitScreen = false;
            clickedBoxes.add(lastClicked);
        } else if (box5.contains(mouse.getPoint()) && !clickedBoxes.contains(box5) && exitScreen) {
            System.out.println("Clicked on box5");
            lastClicked = box5;
            exitScreen = false;

            clickedBoxes.add(lastClicked);
        } else if (box6.contains(mouse.getPoint()) && !clickedBoxes.contains(box6) && exitScreen) {
            System.out.println("Clicked on box6");
            lastClicked = box6;
            exitScreen = false;

            clickedBoxes.add(lastClicked);
        } else if (box7.contains(mouse.getPoint()) && !clickedBoxes.contains(box7) && exitScreen) {
            System.out.println("Clicked on box7");
            lastClicked = box7;
            exitScreen = false;

            clickedBoxes.add(lastClicked);
        } else if (box8.contains(mouse.getPoint()) && !clickedBoxes.contains(box8) && exitScreen) {
            System.out.println("Clicked on box8");
            lastClicked = box8;
            exitScreen = false;

            clickedBoxes.add(lastClicked);
        } else if (box9.contains(mouse.getPoint()) && !clickedBoxes.contains(box9) && exitScreen) {
            System.out.println("Clicked on box9");
            lastClicked = box9;
            exitScreen = false;
            clickedBoxes.add(lastClicked);


        }
        changeTurn();
    }

    /**
     * Interface functions.
     */
    public void mouseExited(MouseEvent mouse) {
        if (clickedBoxes.size() <= 9 && lastClickedFlag == false) {
            System.out.println("Exited boxes");
            exitScreen = true;
            mouseChange(mouse);
          //  changeTurn();
            if (clickedBoxes.size() == 9) {
                lastClickedFlag = true;
            }
        }
    }

    public void mouseChange(MouseEvent mouse) {
        if (lastClicked != null && exitScreen == true) {


            if (oTurn == true) {
                panel2.setBounds(lastClicked.getBounds().x,lastClicked.getBounds().y,lastClicked.getBounds().width,lastClicked.getBounds().height);
                add(panel2);
                oTurn = false;
                xTurn = true;
            } else if (xTurn == true) {
                panel1.setBounds(lastClicked.getBounds().x,lastClicked.getBounds().y,lastClicked.getBounds().width,lastClicked.getBounds().height);

                         add(panel1);
                oTurn = true;
                xTurn = false;

            }

        }
    }

    public void changeTurn(){
       if (xTurn && clickedBoxes.size() < 9){
           turnMessage.setText(O_MESSAGE);
       }
       else if (oTurn && clickedBoxes.size() < 9)
           turnMessage.setText(X_MESSAGE);

    }


    public void setImages(){
        image1.setIcon(new ImageIcon("src/Files/Ximage.jpg"));
        image2.setIcon(new ImageIcon("src/Files/Oimage.png"));
        panel1.add(image1);
        panel2.add(image2);

//        panel1.setVisible(false);
//        panel2.setVisible(false);
        add(panel1);
        add(panel2);

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
        g2 = (Graphics2D) g;
        g2.draw(box);
        g2.draw(box2);
        g2.draw(box3);
        g2.draw(box4);
        g2.draw(box5);
        g2.draw(box6);
        g2.draw(box7);
        g2.draw(box8);
        g2.draw(box9);
    }

//    public void discard(Graphics g, Rectangle box){
//        Graphics2D g2 = (Graphics2D) g;
//        g2.dispose();
//    }
}