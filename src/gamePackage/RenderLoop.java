package gamePackage;

import overworldThings.OverWorldEntity;
import javafx.animation.AnimationTimer;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;

import javafx.scene.image.Image;
import javafx.scene.text.Font;

import java.util.LinkedList;
import java.util.Random;

public class RenderLoop extends AnimationTimer {
	
	private GraphicsContext ctx;
	private Random rng;
	private Canvas screen;
	private Bloom bloomEffect;
	private int frameCount;
	public Image test1;
	private DisplayMode currentMode;
	private LinkedList<OverWorldEntity> renderLayers;
	private boolean isDialogOpen;
	private String dialogText;

	private Image dialogBoxBackground;

	public enum DisplayMode{
		MODE_OVERWORLD,
		MODE_MENU
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
		ctx.setTextBaseline(VPos.TOP);
		ctx.setFont(new Font("MS Reference Sans Serif", 24));

		renderLayers = new LinkedList<OverWorldEntity>();
		
		dialogBoxBackground = new Image(this.getClass().getResource("DialogBoxPic.png").toExternalForm());
	}

	@Override
	public void handle(long now) {

		ctx.clearRect(0, 0, 640, 480);

		//IDEA: Have a switch/case thing to do rendering
        switch (currentMode) {
			case MODE_OVERWORLD:
				for(OverWorldEntity layer : renderLayers){
					//Place each layer down like a celluloid
					ctx.drawImage(layer.getCurrentFrame(), layer.getX() - (layer.getCurrentFrame().getWidth()/2), layer.getY()  - (layer.getCurrentFrame().getHeight()/2));
				}

				if(isDialogOpen){
					ctx.drawImage(dialogBoxBackground, 0, 380);
					ctx.fillText(dialogText, 8, 388, 632);
				}

				break;

			case MODE_MENU:


				break;
		
			default:
				//throw new IllegalStateException("");
		}
		frameCount++;


	}

	public void setMode(DisplayMode mode){
		currentMode = mode;
	}

	public int getFrameCount() {
		return frameCount;
	}

	public void resetFrameCount(){
		frameCount = 0;
	}

	public LinkedList<OverWorldEntity> getRenderLayers(){
		return renderLayers;
	}

	public void setDialogActive(boolean isActive){
		isDialogOpen = isActive;
	}

	public void setDialogText(String text){
		dialogText = text;
	}

}
