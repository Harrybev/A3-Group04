import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;


public class ProfileSettingsController {

    @FXML Button btnChangeProfilePicture;
    @FXML ImageView ivProfilePic;

    public void initialize() {

        Image profileImage = new Image("profile-pics/1.jpg");
        ivProfilePic.setImage(profileImage);

        btnChangeProfilePicture.setOnAction(event -> {
            handleBtnChangeProfilePicture();
        });
    }

    public void handleBtnChangeProfilePicture() {

    }

}
