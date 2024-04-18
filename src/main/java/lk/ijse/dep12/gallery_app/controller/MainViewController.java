package lk.ijse.dep12.gallery_app.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class MainViewController {
    public StackPane notFoundContainer;
    public ScrollPane imageContainerWrapper;
    public TilePane imageContainer;
    public TextField txtLocation;
    public Button btnBrowse;

    public void initialize() {
        txtLocation.setText(System.getProperty("user.home"));
        //btnBrowse.fire();
    }

    public void btnBrowseOnAction(ActionEvent actionEvent) {
        notFoundContainer.setVisible(true);
        imageContainerWrapper.setVisible(false);

        if (txtLocation.getText().isBlank()) {
            txtLocation.requestFocus();
            return;
        }

        DirectoryChooser directoryChooser = new DirectoryChooser();
        File folder = directoryChooser.showDialog(btnBrowse.getScene().getWindow());
        if (folder == null) {
            txtLocation.setText("No Folder Selected");
        }else {
            txtLocation.setText(folder.getAbsolutePath());
        }
        File path = new File(txtLocation.getText());
        if (!path.exists()) {
            new Alert(Alert.AlertType.ERROR, "Invalid folder location").show();
            return;
        } else if (!path.isDirectory()) {
            new Alert(Alert.AlertType.ERROR, "Location does not point to folder").show();
            return;
        }

        imageContainer.getChildren().clear();
        for(File file : path.listFiles()) {
            if (!file.isFile()) continue;
            if ((file.getName().endsWith(".png") || (file.getName().endsWith(".jpeg")) ||
                    (file.getName().endsWith(".jpg") || (file.getName().endsWith(".gif"))))); {
                ImageView imageView = new ImageView(file.toURI().toString());
                imageView.setFitWidth(150);
                imageView.setPreserveRatio(true);
                imageContainer.getChildren().add(imageView);

                if (!imageContainerWrapper.isVisible()) {
                    imageContainerWrapper.setVisible(true);
                    notFoundContainer.setVisible(false);
                }
            }
        }
    }
}
