package gamePackage;



import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("appStructure.fxml"));
        primaryStage.setTitle("Game");
        Scene primaryScene = new Scene(root, 640, 480);
        primaryStage.setScene(primaryScene);
        
        InputHandlerHelper.hook(primaryScene);
        
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}