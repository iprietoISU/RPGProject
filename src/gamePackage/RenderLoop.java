package gamePackage;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Random;

public class RenderLoop extends AnimationTimer {
	
	private GraphicsContext ctx;
	private Random rng;
	private Canvas screen;
	private Bloom bloomEffect;
	private int frameCount;
	public Image test1;
	private DisplayMode currentMode;

	public enum DisplayMode{
		MODE_OVERWORLD,
		MODE_BATTLE
	}

	

	public RenderLoop(GraphicsContext inCtx, Canvas inScr) {
		super();
		currentMode = DisplayMode.MODE_OVERWORLD;
		ctx = inCtx;
		screen = inScr;
		rng = new Random();
		bloomEffect = new Bloom();
		bloomEffect.setThreshold(0.01);
		inScr.setEffect(bloomEffect);
		frameCount = 0;
		ctx.setGlobalAlpha(1);
		ctx.setGlobalBlendMode(BlendMode.SRC_OVER);
		
		
	}

	@Override
	public void handle(long now) {
		frameCount++;
		ctx.clearRect(0, 0, 640, 480);
		ctx.setFill(Color.BLACK);
        ctx.fillRect(0, 0, Math.min(frameCount, 640), 480);
        ctx.stroke();

		//IDEA: Have a switch/case thing to do rendering
        switch (currentMode) {
			case MODE_OVERWORLD:
				
				//Alec, your per-frame rendering code will go here

				break;

			case MODE_BATTLE:

				//Draw BG
				//Draw Characters
				//Advance character frame
				//Draw BattleUI

				break;
		
			default:
				//throw new IllegalStateException("");
		}


	}

	public void setMode(DisplayMode mode){
		currentMode = mode;
	}

}