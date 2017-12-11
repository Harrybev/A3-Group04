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
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.ZonedDateTime;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
* The Account Creation Controller manages all the data that gets passed
* the account creation form.
* 
*
*/
public class AccountCreationController {
  @FXML private TextField txtFieldCounty;
  @FXML private TextField txtFieldAddressLine2;
  @FXML private TextField txtFieldAddressLine1;
  @FXML private TextField txtFieldUsername;
  @FXML private TextField txtFieldLastname;
  @FXML private TextField txtFieldTownOrCity;
  @FXML private TextField txtFieldFirstname;
  @FXML private TextField txtFieldPostcode;
  @FXML private TextField textFieldTelephoneNumber;
  @FXML private Label lblErrorCounty;
  @FXML private Label lblErrorTelephoneNumber;
  @FXML private Label lblErrorUsername;
  @FXML private Label lblErrorLastname;
  @FXML private Label lblErrorFirstname;
  @FXML private Label lblErrorPostcode;
  @FXML private Label lblErrorAddressLine2;
  @FXML private Label lblErrorTownOrCity;
  @FXML private Label lblErrorAddressLine1;
  @FXML private Button btnToLogin;
  @FXML private Button btnCreateAccount;
  @FXML private Stage previousStage;

  final Pattern TELEPHONE_PATTERN = Pattern.compile("^(((\\+44\\s?\\d{4}|\\(?0\\d{4}\\)?)\\s?\\d{3}\\s?\\d{3})|((\\+44\\s?\\d{3}|\\(?0\\d{3}\\)?)\\s?\\d{3}\\s?\\d{4})|((\\+44\\s?\\d{2}|\\(?0\\d{2}\\)?)\\s?\\d{4}\\s?\\d{4}))(\\s?\\#(\\d{4}|\\d{3}))?$");
  final Pattern POST_CODE_PATTERN = Pattern.compile("([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([AZa-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9]?[A-Za-z]))))[0-9][A-Za-z]{2})");


  /**
  *Upon the first call of the form initialize is called and adds the listerner
  * to the correct feilds.
  **/
  public void initialize() {
  txtFieldUsername.textProperty().addListener((( observable, oldValue,
  newValue) -> {validateUsername(newValue.replaceAll("\\s+",""));}));

  textFieldTelephoneNumber.textProperty().addListener(((observable, oldValue,
  newValue) -> {validateTelephoneNumber(newValue.replaceAll("\\s+",""));}));

  txtFieldPostcode.textProperty().addListener(((observable, oldValue,
  newValue) -> {
  validatePostCode(newValue.replaceAll("\\s+",""));
  }));

  }
  /**
  * validateUsername take a String parameter and check that it meets the
  * criteria for username , musn't be taken and not null
  * return error messages if not.
  *@param newValue value to check against.
  **/
  private void validateUsername(String newValue) {
    lblErrorUsername.setText("");
    lblErrorUsername.setTextFill(Color.web("0x008000"));
    if (newValue.equals("")) {
      lblErrorUsername.setText("Please enter a username");
      lblErrorUsername.setTextFill(Color.web("0xC00000"));
    } else if (DataController.getUserTree().searchBST(newValue) != null) {
      lblErrorUsername.setText("Unavailable");
      lblErrorUsername.setTextFill(Color.web("0xC00000"));
    } else {
      lblErrorUsername.setText("Available");
      lblErrorUsername.setTextFill(Color.web("0x008000"));
    }
  }

  /**
  *validate telephone number and reports error messages accordingly
  *@param newValue which contains value to check.
  **/

  private void validateTelephoneNumber(String newValue) {
    Matcher match = TELEPHONE_PATTERN.matcher(newValue);
    if (match.matches()) {
      lblErrorTelephoneNumber.setText("Valid Number");
      lblErrorTelephoneNumber.setTextFill(Color.web("0x008000"));
    } else {
      lblErrorTelephoneNumber.setText("Invalid Number");
      lblErrorTelephoneNumber.setTextFill(Color.web("0xC00000"));
    }
  }
  /**
  *Validates the postcode and return error messages if not
  *@param newValue the value to validate.
  **/
  private void validatePostCode(String newValue) {
    Matcher match = POST_CODE_PATTERN.matcher(newValue);
    if (match.matches()) {
      lblErrorPostcode.setText("Valid Postcode");
      lblErrorPostcode.setTextFill(Color.web("0x008000"));
    } else {
      lblErrorPostcode.setText("Invalid Postcode");
      lblErrorPostcode.setTextFill(Color.web("0xC00000"));
    }
  }

  /**
  *Handles the closingof current form and opening of login form.
  **/
  @FXML public void handleToLogin(){
    Stage registerStage = (Stage) btnCreateAccount.getScene().getWindow();
    registerStage.close();
    this.previousStage.show();
  }
  /**
  *creates a new user and inserts into the User tree then returns to login
  * from
  **/
  @FXML public void handleBtnCreateAccount(){
    lblErrorFirstname.setText("");
    lblErrorLastname.setText("");
    lblErrorAddressLine1.setText("");
    lblErrorTownOrCity.setText("");
    lblErrorFirstname.setTextFill(Color.web("0xC00000"));
    lblErrorLastname.setTextFill(Color.web("0xC00000"));
    lblErrorAddressLine1.setTextFill(Color.web("0xC00000"));
    lblErrorTownOrCity.setTextFill(Color.web("0xC00000"));
    lblErrorUsername.setTextFill(Color.web("0xC00000"));
    lblErrorTelephoneNumber.setTextFill(Color.web("0xC00000"));
    lblErrorPostcode.setTextFill(Color.web("0xC00000"));
    if (lblErrorUsername.getText().equals("Available") &&
    !(txtFieldFirstname.getText().isEmpty()) &&
    !(txtFieldLastname.getText().isEmpty()) &&
    (lblErrorTelephoneNumber.getText().equals("Valid Number")) &&
    !(txtFieldAddressLine1.getText().isEmpty()) &&
    !(txtFieldTownOrCity.getText().isEmpty()) &&
      lblErrorPostcode.getText().equals("Valid Postcode")) {
      Address newAddress = new Address( txtFieldAddressLine1.getText(),
      txtFieldAddressLine2.getText(),
      txtFieldTownOrCity.getText(),
      txtFieldCounty.getText(),
      txtFieldPostcode.getText());
      User newUser = new User(txtFieldUsername.getText(),
      txtFieldFirstname.getText(),
      txtFieldLastname.getText(),
      textFieldTelephoneNumber.getText(),
      newAddress,
      "profile-pics/1.png");
      BSTNode newNode = new BSTNode(newUser);
      DataController.getUserTree().addNode(newNode);
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Registration Notice");
      alert.setHeaderText("Successful Registration");
      alert.setContentText("You have signed up! Your username is: "+txtFieldUsername.getText());
      alert.showAndWait();
      Stage registerStage = (Stage) btnCreateAccount.getScene().getWindow();
      registerStage.close();
      this.previousStage.show();
    } else {
      if (txtFieldUsername.getText().isEmpty()) {
       lblErrorUsername.setText("Username is compulsory");
      }
      if (txtFieldPostcode.getText().isEmpty()) {
       lblErrorPostcode.setText("Postcode is compulsory");
      }
      if (textFieldTelephoneNumber.getText().isEmpty()) {
       lblErrorTelephoneNumber.setText("Telephone number is compulsory");
      }
      if (txtFieldFirstname.getText().isEmpty()) {
       lblErrorFirstname.setText("First Name is compulsory");
      }
      if (txtFieldLastname.getText().isEmpty()) {
       lblErrorLastname.setText("Last Name is compulsory");
      }
      if (txtFieldAddressLine1.getText().isEmpty()) {
       lblErrorAddressLine1.setText("Address line one is compulsory");
      }
      if (txtFieldTownOrCity.getText().isEmpty()) {
       lblErrorTownOrCity.setText("Town or city is compulsory");
      }
    }
  }


 /**
 *Set the previousStage so that you can track back to login
 *@param previousStage the previos window open
 **/
  public void setPreviousStage(Stage previousStage) {
  this.previousStage = previousStage;
  }

}
