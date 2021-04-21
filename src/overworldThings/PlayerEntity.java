package overworldThings;

import gamePackage.RenderLoop;
import javafx.scene.image.Image;

public class PlayerEntity extends OverWorldEntity {

    private RenderLoop graphics;
    private boolean isCameraLockedToPlayer;
    public PlayerEntity(RenderLoop graphicsHook){
        graphics = graphicsHook;
        isCameraLockedToPlayer = true;
    }

    @Override
    public void perTurn(){



        if(isCameraLockedToPlayer){
        int stupidx = getX() + ((int)getCurrentFrame().getWidth())/2;
        int stupidy = getY() + ((int)getCurrentFrame().getHeight())/2;
        graphics.setCameraOffsets(stupidx, stupidy);
        }
    }

    @Override
    public Image getCurrentFrame(){
        return null;
    }

    public void lockCameraToPlayer(boolean isLocked){
        isCameraLockedToPlayer = isLocked;
    }
}
