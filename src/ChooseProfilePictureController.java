import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ChooseProfilePictureController {

    @FXML ImageView iv1;
    @FXML ImageView iv2;
    @FXML ImageView iv3;
    @FXML ImageView iv4;
    @FXML ImageView iv5;
    @FXML ImageView iv6;
    @FXML ImageView iv7;
    @FXML ImageView iv8;
    @FXML Button btnDraw;

    public void initialize() {

        Image image1 = new Image("profile-pics/1.jpg");
        Image image2 = new Image("profile-pics/2.jpg");
        Image image3 = new Image("profile-pics/3.jpg");
        Image image4 = new Image("profile-pics/4.jpg");
        Image image5 = new Image("profile-pics/5.jpg");
        Image image6 = new Image("profile-pics/6.jpg");
        Image image7 = new Image("profile-pics/7.jpg");

        iv1.setImage(image1);
        iv2.setImage(image2);
        iv3.setImage(image3);
        iv4.setImage(image4);
        iv5.setImage(image5);
        iv6.setImage(image6);
        iv7.setImage(image7);

        try {
            Image customImage = new Image("profile-pics/" + DataController.getLoggedInUser().getUsername() + ".jpg");
            iv8.setImage(customImage);
        } catch (IllegalArgumentException e) {
            Image customImage = new Image("profile-pics/drawyourown.jpg");
            iv8.setImage(customImage);
        }

        btnDraw.setOnAction(event -> {
            handleBtnDraw();
        });
    }

    public void handleBtnDraw() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                    ("DrawPanelController.fxml"));

            BorderPane drawPanelRoot = (BorderPane) fxmlLoader.load();

            DrawPanelController drawPanelController = fxmlLoader
                    .<DrawPanelController>getController();

            Scene drawPanelScene = new Scene(drawPanelRoot,
                    Main.MAIN_WINDOW_WIDTH, Main.MAIN_WINDOW_HEIGHT);

            Stage drawPanelStage = new Stage();
            drawPanelStage.setScene(drawPanelScene);
            drawPanelStage.setTitle(Main.WINDOW_TITLE);
            drawPanelStage.initModality(Modality.APPLICATION_MODAL);

            Stage profileSettingsStage = (Stage) btnDraw.getScene().getWindow();

            drawPanelStage.setOnCloseRequest(new EventHandler<
                                WindowEvent>() {
                public void handle(WindowEvent we) {
                    profileSettingsStage.show();
                }
            });

            profileSettingsStage.close();
            drawPanelStage.show();

        } catch (IOException e) {
            e.printStackTrace();

            System.exit(-1);
        }
    }
}
