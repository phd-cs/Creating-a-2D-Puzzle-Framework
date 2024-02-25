import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BaseObjectTest {
    Position startPos = new Position(1,1);
    Position testPos;
    BaseObject object;
    int iconSize = 32;

    @BeforeEach
    public void init(){ object = new BaseObject(startPos); }

    @Test
    void getXIconLocation() {
        int result = object.getXIconLocation(iconSize);
        assertEquals(object.getPosition().getX()*iconSize,result);
        testPos = new Position(2,2);
        object.setPosition(testPos);
        result = object.getXIconLocation(iconSize);
        assertEquals(object.getPosition().getX()*iconSize,result);
    }

    @Test
    void getYIconLocation() {
        int result = object.getYIconLocation(iconSize);
        assertEquals(object.getPosition().getY()*iconSize,result);
        testPos = new Position(2,2);
        object.setPosition(testPos);
        result = object.getYIconLocation(iconSize);
        assertEquals(object.getPosition().getY()*iconSize,result);
    }

    @Test
    void setPosition() {
        object.setPosition(startPos);
        assertEquals(startPos,object.getPosition());
    }

    @Test
    void getPosition() {
        object.setPosition(startPos);
        assertEquals(startPos,object.getPosition());
        testPos = new Position(3,1);
        object.setPosition(testPos);
        assertEquals(testPos,object.getPosition());
    }

    @Test
    void setImage() {
    }

    @Test
    void getImage() {
    }
}