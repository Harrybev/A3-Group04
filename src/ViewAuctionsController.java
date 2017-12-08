import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewAuctionsController {
    @FXML Label lblLoggedInUser;

    User loggedInUser;
    Stage previousStage;

    public void initialize() {

    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
        lblLoggedInUser.setText("Welcome : " + loggedInUser.getUsername());
    }

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }


}
