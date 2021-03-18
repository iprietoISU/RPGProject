package gamePackage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

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
    package gamePackage;
    
    private GraphicsContext screen;
    private GameLoop gameLoop;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        screen = mainCanvasFx.getGraphicsContext2D();
        gameLoop = new GameLoop(screen, mainCanvasFx);
        
        
        gameLoop.start();
        
    }
}