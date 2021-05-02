package overworldThings;

import javafx.scene.image.Image;

public class Goal extends Collidable {

    private Image spriteImage;

    public Goal(){
        spriteImage = new Image(this.getClass().getResource("Goal.png").toExternalForm());
    }

    @Override
    public void collisionLogic(Direction collisionDirection) {
        // TODO Auto-generated method stub
        
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
