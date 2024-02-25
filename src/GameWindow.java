import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;



public class GameWindow {
    private int gridX;
    private int gridY;
    private int squareSize;
    private JFrame window;

    /**
     *
     * Creates a Window which will contain the game grid
     * needs input parameters for knowing how large
     * the grid should be
     * @param x How many rows of squares
     * @param y How many columns of squares
     * @param iconSize the Image size for BaseObjects
     */
    GameWindow(int x, int y,int iconSize) {
        this.gridX = x;
        this.gridY = y;
        squareSize = iconSize;
    }
    //Creates the JFrame and makes it visible
    void makeWindow() {
        window = new JFrame("Framework Game");
        window.setSize(gridX*squareSize+15,gridY*squareSize+40);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    void addToWindow(Component c) {
        window.add(c);
    }
    void redraw(){
        window.repaint();
    }
    void addListener(KeyListener l){
        window.addKeyListener(l);
    }
    void makeVisible(){
        window.setVisible(true);
    }
}
