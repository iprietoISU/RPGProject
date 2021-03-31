package gamePackage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Controller {

    @FXML
    private Canvas mainCanvasFx;
    
    private GraphicsContext screen;
    private RenderLoop renderLoop;
    private boolean killF;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        screen = mainCanvasFx.getGraphicsContext2D();
        renderLoop = new RenderLoop(screen, mainCanvasFx);
        killF = false;
        
        renderLoop.start(); //Async rendering loop, see RenderLoop.java for details

        ////////////////////////////////
        // Actual Logic Loop          //
        ////////////////////////////////

        while(killF){




        };

        
    }

    private void  battleSequence(Battle activeBattle){
        BattleCharacter currCharacter;
        renderLoop.setMode(RenderLoop.DisplayMode.MODE_BATTLE);
        LinkedList<BattleCharacter> BattleChars = new LinkedList<BattleCharacter>();
        Party opfor = activeBattle.getOpfor();
        Party blufor = activeBattle.getBlufor();
        for(int i = 0; i < opfor.getCharactersInParty(); i++){ //Will probably change when I make characters an arraylist
            BattleChars.add(opfor.getCharacter(i));
        }
        for(int i = 0; i < blufor.getCharactersInParty(); i++){ //Will probably change when I make characters an arraylist
            BattleChars.add(blufor.getCharacter(i));
        }
        ListIterator<BattleCharacter> charIterator = BattleChars.listIterator();

        while(!activeBattle.isOver()){
            while(charIterator.hasNext()){
                currCharacter = charIterator.next();
                currCharacter.preBattleEffects();
                if(activeBattle.isOver()){
                    break;
                }
                currCharacter.turn();
                if(activeBattle.isOver()){
                    break;
                }
                currCharacter.postBattleEffects();
                if(activeBattle.isOver()){
                    break;
                }
            }
            if(activeBattle.isOver()){
                break;
            }
            charIterator = BattleChars.listIterator();
        }

        charIterator = BattleChars.listIterator();
        while(charIterator.hasNext()){
            charIterator.next().reset();
        }

        if(!activeBattle.didWin()){
            //game over logic
        }
        
    }
}