import java.awt.*;

/**
 * the Sokoban's game main file that shows an example of the game being played
 */

public class Sokoban {
    private static int iconSize = 32;
    private static GameWindow window = new GameWindow(10,10,iconSize);
    private static Position startingPosition = new Position(5,5);
    private static GameMap gameMap;
    private static SokobanPlayerController playerController;

    public static void main(String[] args) {
        BaseObject[][] objects = new BaseObject[10][10];
        gameMap = new GameMap(objects, window, iconSize,startingPosition);
        SokobanRules rules = new SokobanRules(gameMap);
        playerController = new SokobanPlayerController(gameMap, iconSize, rules);
        rules.addPlayerController(playerController);
        rules.makeSokobanMap(objects);
        gameMap.createMap(objects);
        window.makeWindow();
        window.addToWindow(gameMap);
        window.addListener(playerController.key);
        window.makeVisible();
    }
}
