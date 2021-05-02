package overworldThings;

import java.util.ArrayList;
import java.util.LinkedList;

import gamePackage.DialogBox;
import gamePackage.InputHandlerHelper;
import gamePackage.RenderLoop;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class PlayerEntity extends OverWorldEntity {

    private RenderLoop graphics;
    private boolean isCameraLockedToPlayer;

    private MainGameLogic gameLogic;
    private Image spriteImage;

    private int collisionX1, collisionY1, collisionX2, collisionY2;

    public PlayerEntity(RenderLoop graphicsHook, MainGameLogic gameLogic) {
        graphics = graphicsHook;
        isCameraLockedToPlayer = true;
        this.gameLogic = gameLogic;
        spriteImage = new Image(this.getClass().getResource("Player.png").toExternalForm());
        collisionX1 = 0;
        collisionY1 = 0;
        collisionX2 = 0;
        collisionY2 = 0;
    }

    @Override
    public void perTurn() {

        ArrayList<KeyCode> keys = InputHandlerHelper.getHeldKeys();
        int possibleX = getX();
        int possibleY = getY();
        
        Direction dir = Direction.DOWNWARD;
        //System.out.println(keys);
        if (keys.contains(KeyCode.W)) {
            
            possibleY--;

            dir = Direction.UPWARD;


            collisionX1 = possibleX + 1;
            collisionX2 = possibleX + 28;
            collisionY1 = possibleY+1;
            collisionY2 = possibleY + 2;
        } else if (keys.contains(KeyCode.A)) {
            possibleX--;

            dir = Direction.LEFT;


            collisionX1 = possibleX+1;
            collisionX2 = possibleX+2;
            collisionY1 = possibleY + 1;
            collisionY2 = possibleY + 28;
        } else if (keys.contains(KeyCode.S)) {
            possibleY++;

            dir = Direction.DOWNWARD;

            collisionX1 = possibleX + 1;
            collisionX2 = possibleX + 28;
            collisionY1 = possibleY + 28;
            collisionY2 = possibleY + 29;

        } else if (keys.contains(KeyCode.D)) {
            possibleX++;

            dir = Direction.RIGHT;

            collisionX1 = possibleX+28;
            collisionX2 = possibleX+29;
            collisionY1 = possibleY + 1;
            collisionY2 = possibleY + 28;
        } else {
            if (isCameraLockedToPlayer) {
                int stupidx = getX() + ((int) getCurrentFrame().getWidth()) / 2;
                int stupidy = getY() + ((int) getCurrentFrame().getHeight()) / 2;
                graphics.setCameraOffsets(stupidx, stupidy);
            }
            return;
        }

       
        OverWorldEntity collid = gameLogic.checkCollider(this, true, dir, collisionX1, collisionY1, collisionX2, collisionY2);
        
        if(collid ==null){
            setCoords(possibleX, possibleY);
        } else if(collid.getClass() == Goal.class){
            LinkedList<String> msg = new LinkedList<String>();
            msg.add("You win!");
            DialogBox winMessage = new DialogBox(msg, graphics);
            winMessage.logic();
        } /* else if(collid.getClass() == Box.class && !((Box) collid).getIsBlkd()){
            
            setCoords(possibleX, possibleY);
        } */


        

        
        
        if (isCameraLockedToPlayer) {
            int stupidx = getX() + ((int) getCurrentFrame().getWidth()) / 2;
            int stupidy = getY() + ((int) getCurrentFrame().getHeight()) / 2;
            graphics.setCameraOffsets(stupidx, stupidy);
        }
    }

    @Override
    public Image getCurrentFrame() {
        return spriteImage;
    }

    public void lockCameraToPlayer(boolean isLocked) {
        isCameraLockedToPlayer = isLocked;
    }


    public int getCollisionX1(){
        return collisionX1;
    }

    public int getCollisionY1(){
        return collisionY1;
    }

    public int getCollisionY2(){
        return collisionY2;
    }

    public int getCollisionX2(){
        return collisionX2;
    }
}
