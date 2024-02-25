import javax.swing.*;
import java.awt.*;

/**
 * Class that holds the Objects contained in the grid (gameObjects)
 * Also extends JPanel in order to paint the map and then become attached to the GameWindow
 */

public class GameMap extends JPanel {
    private int iconSize;
    private Position playerStart;
    private static GamePlayerCharacter player;
    private BaseObject[][] gameObjects;
    private GameWindow gameWindow;
    private Boolean isCompleted = false; //if game is finished
    private Boolean needReset = false; //if game needs to be reset

    /**
     *
     * @param gameObjects The BaseObject array of arrays that is used to paint the map
     *                    and should be used in PlayerController for interactions
     * @param gameWindow The GameWindow which creates the window and the GameMap will need to be attached to
     * @param iconSize The Size of the Images used for the BaseObjects
     * @param playerStart Starting Position of player in the current map
     */

    GameMap(BaseObject[][] gameObjects, GameWindow gameWindow, int iconSize,Position playerStart) {
        this.gameObjects = gameObjects;
        this.gameWindow = gameWindow;
        this.iconSize = iconSize;
        this.playerStart = playerStart;
        player = new GamePlayerCharacter(playerStart);
    }

    // Getter for the BaseObject array of arrays
    BaseObject[][] getMapLayout() {return gameObjects;}

    // In order to trigger things that might be needed for when the game resets
    public boolean getNeedReset(){
        return needReset;
    }

    // Should be called when the game has been restarted or reset, if done call
    public void gameWasRestarted() {
        isCompleted = false;
        setNeedReset(true);
        player = new GamePlayerCharacter(playerStart);
    }

    // To set if the game needs to be Reset
    public void setNeedReset(Boolean needReset){this.needReset = needReset;}

    GameWindow getGameWindow(){
        return gameWindow;
    }

    // Paints the gameMap in order for the component to be put in and displayed in the gameWindow
    public void paint(Graphics g) {
        if (isCompleted) {
            g.setColor(new Color(20, 20, 20));
            g.drawString("Congrats you finished the game", 50, 60);
        } else {
            for (BaseObject[] row : gameObjects) {
                for (BaseObject theObj : row) {
                    g.drawImage(theObj.getImage(), theObj.getXIconLocation(iconSize), theObj.getYIconLocation(iconSize), this);
                }
            }
            g.drawImage(player.getImage(), player.getXIconLocation(iconSize), player.getYIconLocation(iconSize), this);
        }
    }

    public void finishedGame() {
        isCompleted = true;
    }

    public void setPlayerStart(Position playerStart){
        this.playerStart = playerStart;
    }

    public Position getPlayerStart(Position playerStart){
        return playerStart;
    }

    // gets player and if game needs reset it resets the Position
    GamePlayerCharacter getPlayer () {
        if (needReset) {
            player = new GamePlayerCharacter(playerStart);
        }
        return player;
    }

    // makes the object given become the object at it's location
    public void changeObject(BaseObject object){
        gameObjects[object.getPosition().getX()][object.getPosition().getY()] = object;
    }

    //creates current map(during runtime)
    public void createMap(BaseObject[][] objects){
        gameObjects = objects;
    }
}