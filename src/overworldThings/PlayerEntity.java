package overworldThings;

import gamePackage.RenderLoop;
import javafx.scene.image.Image;

public class PlayerEntity extends OverWorldEntity {

    private RenderLoop graphics;
    public PlayerEntity(RenderLoop graphicsHook){
        graphics = graphicsHook;
    }

    public void perTurn(){

    }

    public Image getCurrentFrame(){
        return null;
    }
}
