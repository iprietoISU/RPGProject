package overworldThings;


public abstract class Collidable extends OverWorldEntity {

    public boolean didHit(int x_point, int y_point){
        int x2 = getX() + (int)getCurrentFrame().getWidth();
        int y2 = getY() + (int)getCurrentFrame().getHeight();
        return (x_point >= getX() && y_point >= getY() && x_point <= x2 && y_point <= y2);
    }

    public abstract void collisionLogic(Direction collisionDirection);

    
}
