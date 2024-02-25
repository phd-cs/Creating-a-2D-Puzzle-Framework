/**
 * Wall object used by Sokoban
 */

public class WallObject extends BaseObject {

    public WallObject(Position position, ObjType type) {
        super(position);
        setType(type);
        setImage(getToolkit().getImage("src/sokoban_icons/wall.png"));
    }
}
