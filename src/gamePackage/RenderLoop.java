package gamePackage;

import overworldThings.OverWorldEntity;
import javafx.animation.AnimationTimer;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.LinkedList;
import java.util.Random;

public class RenderLoop extends AnimationTimer {

	private final int MID_X = 320;
    private final int MID_Y = 240;
	
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

	private int cameraOffsetX;
	private int cameraOffsetY;

	private int cx1,cx2,cy1,cy2;

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
		cx1 = 0;
		cy1 = 0;
		cx2 = 0;
		cy2 = 0;


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
					int xpos = layer.getX() - cameraOffsetX + MID_X;
					int ypos = layer.getY() - cameraOffsetY + MID_Y;
					ctx.drawImage(layer.getCurrentFrame(), xpos, ypos);
				}

				if(isDialogOpen){
					ctx.drawImage(dialogBoxBackground, 0, 380);
					ctx.fillText(dialogText, 8, 388, 632);
				}

				ctx.setFill(Color.RED);

				ctx.fillRect(cx1 - cameraOffsetX + MID_X ,cy1 - cameraOffsetY + MID_Y,cx2-cx1,cy2-cy1);
				ctx.setFill(Color.BLACK);

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

	public void setCameraOffsets(int x, int y){
		cameraOffsetX = x;
		cameraOffsetY = y;
	}

	public void setInstaBox(int x1, int y1, int x2, int y2){
		cx1 = x1;
		cy1 = y1;
		cx2 = x2;
		cy2 = y2;
	}

}
