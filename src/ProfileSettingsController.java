import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProfileSettingsController {

    @FXML Button btnChangeProfilePicture;

    public void initialize() {


        btnChangeProfilePicture.setOnAction(event -> {
            handleBtnChangeProfilePicture();
        });
    }

    public void handleBtnChangeProfilePicture() {

    }

}
