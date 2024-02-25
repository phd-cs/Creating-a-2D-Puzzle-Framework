public class SokobanPlayerController extends PlayerController {
    private GameMap map;

    SokobanPlayerController(GameMap map, int iconSize, EventListener eventListener) {
        super(map, eventListener, map.getPlayer());
        this.map = map;
    }

    /**
     * function that allows player to move to a location using sokoban logic
     * @param from starting position
     * @param to position player wants to move to
     * @return boolean false if failed to move player and true if player was able to move
     */
    @Override
    public boolean movePlayer(Position from, Position to) {
        int pastX = (to.getX()-from.getX())+to.getX();
        int pastY = (to.getY()-from.getY())+to.getY();
        Position past = new Position(pastX,pastY);
        BaseObject toObject = map.getMapLayout()[to.getX()][to.getY()];
        BaseObject pastObject = map.getMapLayout()[past.getX()][past.getY()];
        //if moving to blank or blankmarked
        if (toObject.getType() == ObjType.BLANK ||toObject.getType() == ObjType.BLANKMARKED) {
            getThePlayer().moveTo(to.getX(),to.getY());
            return true;
        } // if moving to a wall or if the actor past crate is crate wall or cratemarked
        else if (toObject.getType() == ObjType.WALL || pastObject.getType() == ObjType.CRATE
                || pastObject.getType() == ObjType.WALL || pastObject.getType() == ObjType.CRATEMARKED) {
            return false;
        } // if moving to a crate or marked crate
        else if (toObject.getType() == ObjType.CRATE || toObject.getType() == ObjType.CRATEMARKED)  {
            // if past is blank or blankmarked
            if (toObject.getType() == ObjType.CRATE) {//moving crate
                toObject = new FloorObject(toObject.getPosition(),ObjType.BLANK);
            } else {//moving marked crate
                toObject = new FloorObject(toObject.getPosition(),ObjType.BLANKMARKED);
            }
            map.changeObject(toObject);
            getThePlayer().moveTo(to.getX(),to.getY());
            if (pastObject.getType() == ObjType.BLANKMARKED) {
                pastObject = new CrateObject(pastObject.getPosition(),ObjType.CRATEMARKED);
            } else if (pastObject.getType() == ObjType.BLANK) {
                pastObject = new CrateObject(pastObject.getPosition(),ObjType.CRATE);
            }
            map.changeObject(pastObject);
            return true;
        }
        return false;
    }
}
