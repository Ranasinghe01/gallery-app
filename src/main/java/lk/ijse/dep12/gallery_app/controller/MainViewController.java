package lk.ijse.dep12.gallery_app.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.File;

public class MainViewController {
    public TextField txtField;
    public ScrollPane scrollPane;
    public TilePane tilePane;

    public void btnSearchOnAction(ActionEvent actionEvent) {
        String path = txtField.getText();

        File file = new File(path);
        File[] files = file.listFiles();
        tilePane.getChildren().clear();
        for(File file1 : files) {
            if (!file1.isFile()) continue;
            if ((file1.getName().endsWith(".png") || (file1.getName().endsWith(".jpeg")) ||
                    (file1.getName().endsWith(".jpg")))); {
                ImageView imageView = new ImageView(file1.toURI().toString());
                imageView.setFitWidth(150);
                imageView.setFitHeight(150);

                tilePane.getChildren().add(imageView);
            }
        }
    }
}
