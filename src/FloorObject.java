/**
 * Floor object used by Sokoban
 * Checks ObjType to see if marked and change image
 */

public class FloorObject extends BaseObject {

    public FloorObject(Position position, ObjType type) {
        super(position);
        setType(type);
        if (type == ObjType.BLANKMARKED) {
            setImage(getToolkit().getImage("src/sokoban_icons/blankmarked.png"));
        } else {
            setImage(getToolkit().getImage("src/sokoban_icons/blank.png"));
        }
    }
}
