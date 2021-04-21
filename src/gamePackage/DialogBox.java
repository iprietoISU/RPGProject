package gamePackage;

import java.util.LinkedList;

import javafx.scene.input.KeyCode;

public class DialogBox {
    private LinkedList<String> text;
    private RenderLoop graphics;

    
    /**
     * Easily construct a RPG-style dialog box
     * 
     * 
     * @param text - A collection of lines under 39 characters
     * @param graphics - a graphics connection
     */
    public DialogBox(LinkedList<String> text, RenderLoop graphics) {
        this.text = text;
        this.graphics = graphics;
    };


    /**
     * Show the dialog box
     */
    public void logic() {
        graphics.setDialogText("");
        graphics.setDialogActive(true);
        while (!text.isEmpty()) {
            
            if(text.size() >= 2){
                graphics.setDialogText(text.pop() + "\n" + text.pop());
            } else {
                graphics.setDialogText(text.pop());
            }

            while (!InputHandlerHelper.isKeyPressedThenKill(KeyCode.ENTER)) {
                //java broken
                try {
                    Thread.currentThread().sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        graphics.setDialogActive(false);

    }

}
