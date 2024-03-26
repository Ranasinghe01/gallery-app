package lk.ijse.dep12.gallery_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("/view/MainView.fxml");
        AnchorPane container = FXMLLoader.load(resource);
        Scene mainScene = new Scene(container);
        primaryStage.setScene(mainScene);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
