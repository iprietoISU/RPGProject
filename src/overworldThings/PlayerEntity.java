package overworldThings;

import gamePackage.RenderLoop;
import javafx.scene.image.Image;

public class PlayerEntity extends OverWorldEntity {

    private RenderLoop graphics;
    public PlayerEntity(RenderLoop graphicsHook){
        graphics = graphicsHook;
    }

    @Override
    public void perTurn(){

    }

    @Override
    public Image getCurrentFrame(){
        return null;
    }
}
