package bsu.comp152;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DataDisplayDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        var loc = getClass().getResource("Window.fxml");
        Parent root = null;
        try {
            root = FXMLLoader.load(loc);
        }catch (IOException e){
            System.out.println("Couldn't Find FXML file!!!!!!");
        }
        Scene windowContents = new Scene(root, 1100,600);
        primaryStage.setScene(windowContents);
        primaryStage.setTitle("Demo of using textboxes to display data");
        primaryStage.show();
    }

    public void loadData(ActionEvent event){

    }
}
