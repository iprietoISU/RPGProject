package overworldThings;

import javafx.scene.image.Image;

public class Wall extends Collidable {

    private Image spriteImage;

    public Wall(){
        spriteImage = new Image(this.getClass().getResource("Wall.png").toExternalForm());
    }

    @Override
    public void collisionLogic(Direction collisionDirection) {
         //spriteImage = new Image(this.getClass().getResource("BoxPushable.png").toExternalForm());
        
    }

    @Override
    public void perTurn() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Image getCurrentFrame() {
        // TODO Auto-generated method stub
        return spriteImage;
    }
    
}
