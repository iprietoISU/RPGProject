package overworldThings;

import gamePackage.RenderLoop;
import javafx.scene.image.Image;

public class Box extends Collidable{
    private Image spriteImage;
    private MainGameLogic gameLogic;
    private boolean isBlkd;
    private RenderLoop graphics;
    public Box(MainGameLogic gameLogic, RenderLoop graphicsL) {
        spriteImage = new Image(this.getClass().getResource("BoxPushable.png").toExternalForm());
        this.gameLogic = gameLogic;
        graphics = graphicsL;
        isBlkd = false;
    }

    public boolean getIsBlkd() {
        return isBlkd;
    }

    @Override
    public void collisionLogic(Direction collisionDirection) {
        isBlkd = false;
        int possibleX = getX();
        int possibleY = getY();
        int collisionX1 = 0;
        int collisionX2 = 0;
        int collisionY1 = 0;
        int collisionY2 = 0;
        Direction dir = Direction.DOWNWARD;
        //System.out.println(keys);
        if (collisionDirection == Direction.UPWARD) {
            possibleY--;

            dir = Direction.UPWARD;


            collisionX1 = possibleX + 1;
            collisionX2 = possibleX + 28;
            collisionY1 = possibleY+1;
            collisionY2 = possibleY + 2;
        } else if (collisionDirection == Direction.LEFT) {
            possibleX--;

            dir = Direction.LEFT;


            collisionX1 = possibleX+1;
            collisionX2 = possibleX+2;
            collisionY1 = possibleY + 1;
            collisionY2 = possibleY + 28;
        } else if (collisionDirection == Direction.DOWNWARD) {
            possibleY++;

            dir = Direction.DOWNWARD;

            collisionX1 = possibleX + 1;
            collisionX2 = possibleX + 28;
            collisionY1 = possibleY + 28;
            collisionY2 = possibleY + 29;

        } else if (collisionDirection == Direction.RIGHT) {
            possibleX++;

            dir = Direction.RIGHT;

            collisionX1 = possibleX+28;
            collisionX2 = possibleX+29;
            collisionY1 = possibleY + 1;
            collisionY2 = possibleY + 28;
        }

        //graphics.setInstaBox(collisionX1, collisionY1, collisionX2, collisionY2);

        if(gameLogic.checkCollider(this, false, Direction.DOWNWARD, collisionX1, collisionY1, collisionX2, collisionY2) == null){
            setCoords(possibleX,possibleY);
        } else {
            isBlkd = true;
        }
        
    }

    @Override
    public void perTurn() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Image getCurrentFrame() {
        return spriteImage;
    }
    
}
