import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerControllerTest {
    PlayerController pc;

    @BeforeEach
    void init(){
        GameWindow gameWindow = new GameWindow(500,500,32);
        BaseObject[][] baseObjects = new BaseObject [2][2];
        Position pos = new Position(0,1);
        GamePlayerCharacter player = new GamePlayerCharacter(pos);
        GameMap gameMap = new GameMap(baseObjects,gameWindow,32,pos);
        EventListener eventListener = new EventListener() {
            @Override
            public void eventTrigger() { }
        };
        pc = new PlayerController(gameMap,eventListener,player);
    }

    @Test
    void setThePlayer() {
        GamePlayerCharacter newPlayer = new GamePlayerCharacter(new Position(1,1));
        pc.setThePlayer(newPlayer);
        assertEquals(newPlayer,pc.getThePlayer());
    }

    @Test
    void getThePlayer() {
        GamePlayerCharacter newPlayer = new GamePlayerCharacter(new Position(1,1));
        pc.setThePlayer(newPlayer);
        assertEquals(newPlayer,pc.getThePlayer());
        newPlayer = new GamePlayerCharacter(new Position(0,0));
        pc.setThePlayer(newPlayer);
        assertEquals(newPlayer,pc.getThePlayer());
    }
}