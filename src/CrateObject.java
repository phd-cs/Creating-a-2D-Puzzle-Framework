/**
 * Crate object used by Sokoban
 * Checks ObjType to see if marked and change image
 */

public class CrateObject extends BaseObject {

    public CrateObject(Position position, ObjType type) {
        super(position);
        setType(type);
        if (type == ObjType.CRATEMARKED) {
            setImage(getToolkit().getImage("src/sokoban_icons/cratemarked.png"));
        } else {
            setImage(getToolkit().getImage("src/sokoban_icons/crate.png"));
        }
    }
}
