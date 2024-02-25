import java.awt.*;

/**
 * BaseObject used for the GameMap to create the map
 * and for PlayerController to facilitate interactions
 * between different BaseObjects
 */

class BaseObject {
    private Position position;
    private Enum type;
    private Image image;
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();

    /**
     * This class uses encapsulation and has Getters and Setters needed
     * Children if wanting to be drawn should have an Image, if needed
     * to ease game logic they can have an Enumerator
     * @param position the position that the BaseObject should be located at
     */
    public BaseObject(Position position) {
        this.position = position;
    }

    public int getXIconLocation(int iconSize) {
        return position.getX()*iconSize;
    }

    public int getYIconLocation(int iconSize) {
        return position.getY()*iconSize;
    }

    public static Toolkit getToolkit() {
        return toolkit;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position newPosition) {
        position = newPosition;
    }

    public Enum getType(){
        return type;
    }

    public void setType(Enum newType) {
        type = newType;
    }

    public void setImage(Image newImage) {
        image = newImage;
    }

    public Image getImage() {
        return image;
    }
}