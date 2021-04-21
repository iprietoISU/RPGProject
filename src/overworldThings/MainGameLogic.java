package overworldThings;

import java.util.LinkedList;

import gamePackage.DialogBox;
import gamePackage.RenderLoop;

public class MainGameLogic {
    private RenderLoop graphics;
    private LinkedList<OverWorldEntity> layers;

    private final int MID_X = 320;
    private final int MID_Y = 240;

    public MainGameLogic(RenderLoop graphicsHook) {
        graphics = graphicsHook;
        layers = graphics.getRenderLayers();
    }

    public void doStep(int logicFrameCount){
        if(logicFrameCount == 5){
            LinkedList<String> sad = new LinkedList<String>();
            sad.add("test1");
            sad.add("test2");
            sad.add("test3");
            sad.add("test4");
            sad.add("test5");
            sad.add("test6");
            sad.add("test7");
            DialogBox dlgBx = new DialogBox(sad, graphics);
            dlgBx.logic();
        }
        
    }
}
