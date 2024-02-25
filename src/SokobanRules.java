/**
 * Class containing the game rules for Sokoban for the one map that has been created.
 * If a new map would be desired one could use the finished game logic and send it to a new map once
 * the game has been finished.
 */

public class SokobanRules implements EventListener {
    private GameMap gameMap;
    private int marks = 5;
    private PlayerController playerController;

    SokobanRules(GameMap gameMap){
        this.gameMap = gameMap;
    }

    //the playercontroller used
    public void addPlayerController(SokobanPlayerController playerController){
        this.playerController = playerController;
    }

    //checks win condition in sokoban
    public void gameCheck(GameMap gameMap){
        BaseObject[][] objects = gameMap.getMapLayout();
        int completedAmount = 0;
        for (BaseObject[] row : objects) {
            for (BaseObject theObj : row) {
                if (theObj.getType() == ObjType.CRATEMARKED) {
                    completedAmount++;
                }
            }
        }
        if (completedAmount == marks) {
            gameMap.finishedGame();
            makeSokobanMap(gameMap.getMapLayout());
        }
    }

    //handles game logic in KeyListener through observing in PlayerController
    @Override
    public void eventTrigger() {
        gameCheck(gameMap);
        if (gameMap.getNeedReset()) {
            makeSokobanMap(gameMap.getMapLayout());
            gameMap.setNeedReset(false);
        }
        playerController.setThePlayer(gameMap.getPlayer());
    }

    /**
     * Creates and puts a map in the array of arrays of BaseObjects
     * @param objects the array of arrays of BaseObjects that needs to become the map
     */
    public void makeSokobanMap(BaseObject[][] objects){
        for (int i = 0; i < objects.length; i++) {
            for (int j = 0; j < objects[i].length; j++) {
                objects[i][j] = new FloorObject(new Position(i,j),ObjType.BLANK);
                if (i == 1 || i == 8) {
                    objects[i][j] = new WallObject(new Position(i,j),ObjType.WALL);
                    if (j == 0 || j == 9) {
                        objects[i][j] = new FloorObject(new Position(i,j),ObjType.BLANK);
                    }
                } if (j == 1 || j == 8){
                    if (!(i == 0 || i == 9)) {
                        objects[i][j] = new WallObject(new Position(i,j),ObjType.WALL);
                    }
                }
            }
        }
        objects[2][2] = new FloorObject(new Position(2,2), ObjType.BLANKMARKED);
        objects[3][3] = new FloorObject(new Position(3,3), ObjType.BLANKMARKED);
        objects[2][3] = new FloorObject(new Position(2,3), ObjType.BLANKMARKED);
        objects[3][2] = new FloorObject(new Position(3,2), ObjType.BLANKMARKED);
        objects[4][3] = new FloorObject(new Position(4,3), ObjType.BLANKMARKED);
        objects[4][6] = new CrateObject(new Position(4,6), ObjType.CRATE);
        objects[4][5] = new CrateObject(new Position(4,5), ObjType.CRATE);
        objects[6][5] = new CrateObject(new Position(6,5), ObjType.CRATE);
        objects[6][4] = new CrateObject(new Position(6,4), ObjType.CRATE);
        objects[4][4] = new CrateObject(new Position(4,4), ObjType.CRATE);
    }

}
