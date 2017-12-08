import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewAuctionsController {
    @FXML Label lblLoggedInUser;
    @FXML Hyperlink lnkProfilePage;

    private DataController data;
    private Stage previousStage;

//    public void initialize() {
//
//
//        lnkProfilePage.setOnAction(event -> {
//            handleBtnLoginAction();
//        });
//
//    }

    public void handleLnkProfilePageAction() {


    }

    public void setDataController(DataController data) {
        this.data = data;
    }


}
