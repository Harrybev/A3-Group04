import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.paint.Color;


public class AccountCreationController {
    @FXML TextField txtFieldCounty;
    @FXML TextField txtFieldAddressLine2;
    @FXML TextField txtFieldAddressLine1;
    @FXML TextField txtFieldUsername;
    @FXML TextField txtFieldLastname;
    @FXML TextField txtFieldTownOrCity;
    @FXML TextField txtFieldFirstname;
    @FXML TextField txtFieldPostcode;
    @FXML Label lblErrorCounty;
    @FXML Label lblErrorTelephoneNumber;
    @FXML Label lblErrorUsername;
    @FXML Label lblErrorLastname;
    @FXML Label lblErrorFirstname;
    @FXML Label lblErrorPostcode;
    @FXML Label lblErrorAddressLine2;
    @FXML Label lblErrorTownOrCity;
    @FXML Label lblErrorAddressLine1;
    @FXML Button btnToLogin;
    @FXML Button btnCreateAccount;

    private BST userTree = new BST();
    private Stage previousStage;

    public void initialize() {
        userTree = ReadFiles.readUsers();
    }

    @FXML public void validateFieldUsername(){
        if (userTree.searchBST(txtFieldUsername.getText()) == null) {
          lblErrorUsername.setText("Please enter a username");
          lblErrorUsername.setTextFill(Color.web("#C00000 "));
        }else if (userTree.searchBST(txtFieldUsername.getText()) != null) {
          lblErrorUsername.setText("Available");
          lblErrorUsername.setTextFill(Color.web("#228B22"));
          return;
        } else {

        }

    }

    @FXML public void validateFieldPostcode(){

    }

    @FXML public void handleToLogin(){


    }

    @FXML public void handleBtnCreateAccount(){

    }

    @FXML public void validateTelephoneNumber(){

    }

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

}
