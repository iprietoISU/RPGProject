package gamePackage;


import java.util.LinkedList;
import java.util.ListIterator;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.layout.AnchorPane;
import overworldThings.MainGameLogic;

public class Controller {

    @FXML
    private Canvas mainCanvasFx;

    @FXML
    private AnchorPane aFrame;

    private GraphicsContext screen;
    private RenderLoop renderLoop;
    private boolean killF;
    int logicFrameCount;

    public void initialize() {
        // String javaVersion = System.getProperty("java.version");
        // String javafxVersion = System.getProperty("javafx.version");
        screen = mainCanvasFx.getGraphicsContext2D();
        renderLoop = new RenderLoop(screen, mainCanvasFx);
        killF = false;
        logicFrameCount = 0;

        MainGameLogic gameLogic = new MainGameLogic(renderLoop);

        // mainCanvasFx.addEventFilter(KeyEvent.KEY_PRESSED, whyAmIAlive);

        renderLoop.start(); // Async rendering loop, see RenderLoop.java for details
        System.out.println("Game rendering...");
        ////////////////////////////////
        // Actual Logic Loop //
        ////////////////////////////////

        Thread logicThread = new Thread(() -> {
            long timeSinceLogicStart = System.currentTimeMillis();
            while (!killF) { // Locked to 60 Hertz speed

                

                //Progression logic should be done here

                
                gameLogic.doStep(logicFrameCount);



                while (System.currentTimeMillis() - timeSinceLogicStart < 17) {
                    // Waiting...
                }
                logicFrameCount++;
                timeSinceLogicStart = System.currentTimeMillis();
            }
        });

        logicThread.start();

    }

    private void battleSequence(Battle activeBattle) {
        BattleCharacter currCharacter;
        renderLoop.setMode(RenderLoop.DisplayMode.MODE_MENU);
        LinkedList<BattleCharacter> BattleChars = new LinkedList<BattleCharacter>();
        Party opfor = activeBattle.getOpfor();
        Party blufor = activeBattle.getBlufor();
        for (int i = 0; i < opfor.getCharactersInParty(); i++) { // Will probably change when I make characters an
                                                                 // arraylist
            BattleChars.add(opfor.getCharacter(i));
        }
        for (int i = 0; i < blufor.getCharactersInParty(); i++) { // Will probably change when I make characters an
                                                                  // arraylist
            BattleChars.add(blufor.getCharacter(i));
        }
        ListIterator<BattleCharacter> charIterator = BattleChars.listIterator();

        while (!activeBattle.isOver()) {
            while (charIterator.hasNext()) {
                currCharacter = charIterator.next();
                currCharacter.preBattleEffects();
                if (activeBattle.isOver()) {
                    break;
                }
                currCharacter.turn();
                if (activeBattle.isOver()) {
                    break;
                }
                currCharacter.postBattleEffects();
                if (activeBattle.isOver()) {
                    break;
                }
            }
            if (activeBattle.isOver()) {
                break;
            }
            charIterator = BattleChars.listIterator();
        }

        charIterator = BattleChars.listIterator();
        while (charIterator.hasNext()) {
            charIterator.next().reset();
        }

        if (!activeBattle.didWin()) {
            // game over logic
        }

    }
}