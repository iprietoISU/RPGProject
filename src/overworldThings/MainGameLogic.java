package overworldThings;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import gamePackage.DialogBox;
import gamePackage.RenderLoop;

public class MainGameLogic {
    private RenderLoop graphics;
    private LinkedList<OverWorldEntity> layers;
    private LinkedList<Collidable> collidables;

    private PlayerEntity mainPlayer;



    public MainGameLogic(RenderLoop graphicsHook) {
        graphics = graphicsHook;
        layers = graphics.getRenderLayers();
        collidables = new LinkedList<Collidable>();
        try {
            scanInLevel();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void doStep(int logicFrameCount) {
            for(OverWorldEntity e : layers){
                e.perTurn();
            }
    }

    public PlayerEntity getPlayer() {
        return mainPlayer;
    }

    public int getXBound(){
        return 30*15;
    }

    public int getYBound(){
        return 30*15;
    }

    public OverWorldEntity checkCollider(OverWorldEntity caller, boolean doLogic, Direction collisionDirection, int x1, int y1, int x2, int y2){




        for(Collidable e : collidables){
            if(e.equals(caller)){
                continue;
            }

            boolean didHit = e.didHit(caller, x1, y1, x2, y2);
            //System.out.println(didHit);
            if(didHit){
                if(doLogic){
                    e.collisionLogic(collisionDirection);
                }

                return e;
            }
        }
        return null;
    }

    private void scanInLevel() throws IOException{
        File lvl = new File("Level2.txt");
        Scanner scanner = new Scanner(lvl);
        scanner.useDelimiter("");
        int coordtrack = -1;
        while(scanner.hasNext()){
            String in = scanner.next();
            System.out.println((coordtrack % 15) * 30 + " : " + (coordtrack / 15) * 30 + " : " + in);
            
            coordtrack++;
            switch (in) {
                case "W":
                    Wall newWall = new Wall();
                    newWall.setCoords((coordtrack % 15) * 30, (coordtrack / 15) * 30);
                    collidables.add(newWall);
                    layers.add(newWall);
                    break;

                case "B":
                    Box newBox = new Box(this, graphics);
                    newBox.setCoords((coordtrack % 15) * 30, (coordtrack / 15) * 30);
                    collidables.add(newBox);
                    layers.add(newBox);
                    break;

                case "P":
                    mainPlayer = new PlayerEntity(graphics, this);
                    mainPlayer.setCoords((coordtrack % 15) * 30, (coordtrack / 15) * 30);
                    layers.add(mainPlayer);
                    break;

                case "G":
                    Goal newGoal = new Goal();
                    newGoal.setCoords((coordtrack % 15) * 30, (coordtrack / 15) * 30);
                    collidables.add(newGoal);
                    layers.add(newGoal);
                    break;

                case " ":
                    break;
            
                default:
                    coordtrack--;
                    break;
            }
            
        }
    }

}
