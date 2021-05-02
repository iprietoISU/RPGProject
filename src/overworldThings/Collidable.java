package overworldThings;


public abstract class Collidable extends OverWorldEntity {

    public boolean didHit(OverWorldEntity entity, int ex1, int ey1, int ex2, int ey2){
        int x2 = getX() + (int)getCurrentFrame().getWidth();
        int y2 = getY() + (int)getCurrentFrame().getHeight();
        
        boolean didActuallyHit = ExtraMathUtils.doRectsIntersect(getX(), getY(), x2, y2, ex1, ey1, ex2, ey2);

        return didActuallyHit;
        
    }

    private boolean isWithin(int i, int a, int b){
        return (a < i && i < b);
    }


    public abstract void collisionLogic(Direction collisionDirection);

    
}
