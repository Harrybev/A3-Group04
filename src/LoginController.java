import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class LoginController {
    @FXML Button btnLogin;
    @FXML TextField txtUsername;
    @FXML Hyperlink hyplinkCreateAccount;
    private BST userTree = new BST();

    // Initialises the controller and apparently gets called automatically
    public void initialize() {
        userTree = ReadFiles.readUsers();

        // Setup actions on controls
        btnLogin.setOnAction(event -> {
            handleBtnLoginAction();
        });
    }
    @FXML
    private void handleHyplinkCreateAccount(ActionEvent event)  throws Exception {


    }

    private void handleBtnLoginAction() {
        if (userTree.searchBST(txtUsername.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Username not found");
            alert.setHeaderText(null);
            alert.setContentText("Please enter another username.");
            alert.showAndWait();
            return;
        } else {
            // stores the currently logged in user
            User loggedInUser = (User) userTree.searchBST(txtUsername.getText())
                    .getSortable();

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                        ("ViewAuctions.fxml"));

                AnchorPane viewAuctionsRoot = (AnchorPane) fxmlLoader.load();

                ViewAuctionsController viewActionController = fxmlLoader
                        .<ViewAuctionsController>getController();

                viewActionController.setLoggedInUser(loggedInUser);

                Scene viewAuctionsScene = new Scene(viewAuctionsRoot,
                        Main.MAIN_WINDOW_WIDTH, Main.MAIN_WINDOW_HEIGHT);

                Stage viewAuctionsStage = new Stage();
                viewAuctionsStage.setScene(viewAuctionsScene);
                viewAuctionsStage.setTitle(Main.WINDOW_TITLE);

                viewAuctionsStage.initModality(Modality.APPLICATION_MODAL);


                Stage loginStage = (Stage) btnLogin.getScene().getWindow();
                loginStage.hide();
                viewAuctionsStage.showAndWait();
                loginStage.show();


            } catch (IOException e) {
                e.printStackTrace();

                System.exit(-1);
            }



        }
    }



}
