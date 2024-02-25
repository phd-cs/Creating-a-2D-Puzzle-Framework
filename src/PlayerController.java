import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController {
    private GameMap map;
    private GamePlayerCharacter thePlayer;
    private GameWindow window;
    private final int UP = 38;
    private final int DOWN = 40;
    private final int LEFT = 37;
    private final int RIGHT = 39;
    private final int RESET = 82;
    private EventListener eventListener;

    /**
     *
     * @param map GameMap that is being played
     * @param eventListener EventListener that will be recieving trigger at end of a button press
     * @param player Player that is being controlled
     */
    PlayerController(GameMap map, EventListener eventListener, GamePlayerCharacter player) {
        this.map = map;
        thePlayer = player;
        window = map.getGameWindow();
        this.eventListener = eventListener;
    }

    public GamePlayerCharacter getThePlayer(){
        return thePlayer;
    }

    public void setThePlayer(GamePlayerCharacter newPlayer){
        thePlayer = newPlayer;
    }

    /**
     * function that should be overridden in a child class
     * @param from starting position
     * @param to position player wants to move to
     * @return boolean false if failed to move player and true if player was able to move
     */
    public boolean movePlayer(Position from,Position to) {
        return false;
    }

    /**
     * listening for arrow key presses and r and gives current
     * and intended position to movePlayer
     */
    KeyListener key = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            Position curPos = thePlayer.getPosition();
            Position toPos = new Position(thePlayer.getPosition().getX(),thePlayer.getPosition().getY());
            switch (e.getKeyCode()) {
                case UP: { //up
                    toPos.setY(curPos.getY() - 1);
                    movePlayer(curPos,toPos);
                    break;
                }
                case DOWN: { //down
                    toPos.setY(curPos.getY() + 1);
                    movePlayer(curPos,toPos);
                    break;
                }
                case LEFT: { //left
                    toPos.setX(curPos.getX() - 1);
                    movePlayer(curPos,toPos);
                    break;
                }
                case RIGHT: {//right
                    toPos.setX(curPos.getX() + 1);
                    movePlayer(curPos,toPos);
                    break;
                }
                case RESET: {//restart (r button is pressed)
                    map.gameWasRestarted();
                    map.createMap(map.getMapLayout());
                    map.getNeedReset();
                    break;
                }
                default: {
                    break;
                }
            }
            eventListener.eventTrigger();
            window.redraw();
            map.addKeyListener(this);
            window.addToWindow(map);
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    };
}
