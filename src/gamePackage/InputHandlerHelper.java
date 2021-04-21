package gamePackage;


import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandlerHelper{

    private static ArrayList<KeyCode> heldKeys = new ArrayList<KeyCode>();

    public static void hook(Scene scene){
        EventHandler<KeyEvent> keyPressHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(!heldKeys.contains(event.getCode())){
                    heldKeys.add(event.getCode());
                }
            } 
        };

        EventHandler<KeyEvent> keyReleaseHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                heldKeys.remove(event.getCode());

            } 
        };

        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressHandler);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleaseHandler);
    }

    public static ArrayList<KeyCode> getHeldKeys(){
        return heldKeys;
    }

    public static boolean isKeyPressedThenKill(KeyCode code){
        return heldKeys.remove(code);
    }

    public static void silentlyReleaseAllKeys(){
        heldKeys.clear();
    }
}