package overworldThings;

import javafx.scene.image.Image;
public abstract class OverWorldEntity {
    private int x, y;
    public abstract void perTurn();
    public abstract Image getCurrentFrame();

    public void setCoords(int x, int y){
        this.x = x;
        this.y = y;
    };

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
        
}
