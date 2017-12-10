import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;


public class ProfileSettingsController {

    @FXML Button btnChangeProfilePicture;
    @FXML ImageView ivProfilePic;

    public void initialize() {

        Image profileImage = new Image(DataController.getLoggedInUser().
                getProfileImagePath());
        ivProfilePic.setImage(profileImage);

        btnChangeProfilePicture.setOnAction(event -> {
            handleBtnChangeProfilePicture();
        });
    }

    public void handleBtnChangeProfilePicture() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChooseProfilePicture.fxml"));

            BorderPane choosePictureRoot = (BorderPane) fxmlLoader.load();

            ChooseProfilePictureController choosePictureController = fxmlLoader
                    .<ChooseProfilePictureController>getController();

            Scene choosePictureScene = new Scene(choosePictureRoot,
                    Main.MAIN_WINDOW_WIDTH, Main.MAIN_WINDOW_HEIGHT);

            Stage chooseProfilePictureStage = new Stage();
            chooseProfilePictureStage.setScene(choosePictureScene);
            chooseProfilePictureStage.setTitle(Main.WINDOW_TITLE);
            chooseProfilePictureStage.initModality(Modality.APPLICATION_MODAL);

            Stage viewProfileSettingsStage = (Stage) btnChangeProfilePicture.
                    getScene().getWindow();

            chooseProfilePictureStage.setOnCloseRequest(new EventHandler<
                    WindowEvent>() {
                public void handle(WindowEvent we) {
                    viewProfileSettingsStage.show();
                    refreshImage();
                }
            });

            viewProfileSettingsStage.close();
            chooseProfilePictureStage.show();

        } catch (IOException e) {
            e.printStackTrace();

            System.exit(-1);
        }
    }

    private void refreshImage() {
        Image profileImage = new Image(DataController.getLoggedInUser().
                getProfileImagePath());
        ivProfilePic.setImage(profileImage);
    }
}
