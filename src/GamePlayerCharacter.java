/**
 * The player character that has a moveTo function in order to move, and is in the GameMap
 * object and painted above the map
 */

class GamePlayerCharacter extends BaseObject {

    GamePlayerCharacter(Position position) {
        super(position);
        setImage(getToolkit().getImage("src/sokoban_icons/player.png"));
    }

    public void moveTo(int x, int y) {
        setPosition(new Position(x,y));
    }
}
