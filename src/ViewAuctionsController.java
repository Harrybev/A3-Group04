import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ViewAuctionsController {
    @FXML Button btnReturn;
    @FXML Label lblLoggedInUser;

    User loggedInUser;

    public void initialize() {
        btnReturn.setOnAction(event -> {
            handleRtnButtonAction();
        });

    }

    public void handleRtnButtonAction() {

    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
        lblLoggedInUser.setText("Welcome : " + loggedInUser.getUsername());
    }
}
