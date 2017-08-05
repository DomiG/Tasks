package io.github.domig.tasks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui.fxml"));
        loader.setController(loader.getController());
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Tasks 0.1");
        primaryStage.setScene(new Scene(root, 645, 400));
        primaryStage.setMaxHeight(400);
        primaryStage.setMaxWidth(645);
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(645);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

