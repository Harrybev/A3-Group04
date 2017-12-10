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

//import javafx.scene.control.TextInputControl.TextProperty;


public class AccountCreationController {
    @FXML TextField txtFieldCounty;
    @FXML TextField txtFieldAddressLine2;
    @FXML TextField txtFieldAddressLine1;
    @FXML TextField txtFieldUsername;
    @FXML TextField txtFieldLastname;
    @FXML TextField txtFieldTownOrCity;
    @FXML TextField txtFieldFirstname;
    @FXML TextField txtFieldPostcode;
    @FXML TextField textFieldTelephoneNumber;
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

    private Stage previousStage;


    Pattern telephonePattern = Pattern.compile("^(((\\+44\\s?\\d{4}|\\(?0\\d{4}\\)?)\\s?\\d{3}\\s?\\d{3})|((\\+44\\s?\\d{3}|\\(?0\\d{3}\\)?)\\s?\\d{3}\\s?\\d{4})|((\\+44\\s?\\d{2}|\\(?0\\d{2}\\)?)\\s?\\d{4}\\s?\\d{4}))(\\s?\\#(\\d{4}|\\d{3}))?$");
    Pattern postcodePattern = Pattern.compile("([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([AZa-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9]?[A-Za-z]))))[0-9][A-Za-z]{2})");

    private void initialize() {

    }

    /*txtFieldUsername.FocusedProperty().addListener((observable, oldValue, newValue) -> {
    if(!newValue) {
      lblErrorUsername.setText("Please enter a username");
      lblErrorUsername.setTextFill(Color.web("#C00000 "));
    }   if (userTree.searchBST(txtFieldUsername.getText()).getSortable().getSearchKey() == txtFieldUsername.getText()) {
        System.out.println(userTree.searchBST(txtFieldUsername.getText()).getSortable().getSearchKey());
        lblErrorUsername.setText("Unavailabale");
        lblErrorUsername.setTextFill(Color.web("#C00000"));
      }
    });*/


// Handle TextField enter key event.




    @FXML public void validateFieldUsername(KeyEvent event){
        lblErrorUsername.setText("");
        lblErrorUsername.setTextFill(Color.web("0x008000"));
        if (txtFieldUsername.getText().trim().isEmpty()) {
          lblErrorUsername.setText("Please enter a username");
          lblErrorUsername.setTextFill(Color.web("0xC00000"));
          return ;
        }
        System.out.println(txtFieldUsername.getText());
        lblErrorUsername.setText("Available");
        if (DataController.getUserTree().searchBST(txtFieldUsername.getText().replaceAll("\\s+","")).getSortable().getSearchKey().equals(txtFieldUsername.getText().replaceAll("\\s+",""))) {
          lblErrorUsername.setText("Unavailable");
          lblErrorUsername.setTextFill(Color.web("0xC00000"));
          return ;
        }

    }

    @FXML public void validateTelephoneNumber(KeyEvent event){
      String telephoneNumber = textFieldTelephoneNumber.getText().replaceAll("\\s+","");
      Matcher match = telephonePattern.matcher(telephoneNumber);
      System.out.println(match.matches());
      if(match.matches()){
        lblErrorTelephoneNumber.setText("Valid Number");
        lblErrorTelephoneNumber.setTextFill(Color.web("0x008000"));
      }else{
        lblErrorTelephoneNumber.setText("Invalid Number");
      }
    }

    @FXML public void validateFieldPostcode(){
      String postCode = txtFieldPostcode.getText().replaceAll("\\s+","");
      Matcher match = postcodePattern.matcher(postCode);
      if(match.matches()){
        lblErrorPostcode.setText("Valid Postcode");
        lblErrorPostcode.setTextFill(Color.web("0x008000"));
      }else{
        lblErrorPostcode.setText("Invalid Postcode");
      }
    }

    @FXML public void handleToLogin(){
      Stage registerStage = (Stage) btnCreateAccount.getScene().getWindow();

      registerStage.close();
      this.previousStage.show();
    }

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
        if(lblErrorUsername.getText().equals("Available") &&
         !(txtFieldFirstname.getText().isEmpty()) &&
         !(txtFieldLastname.getText().isEmpty()) &&
         (lblErrorTelephoneNumber.getText().equals("Valid Number")) &&
         !(txtFieldAddressLine1.getText().isEmpty()) &&
         !(txtFieldTownOrCity.getText().isEmpty()) &&
         lblErrorPostcode.getText().equals("Valid Postcode")){
           Address newAddress = new Address( txtFieldAddressLine1.getText(),
           txtFieldAddressLine2.getText(),
           txtFieldTownOrCity.getText(),
           txtFieldCounty.getText(),
           txtFieldPostcode.getText()
           );
           User newUser = new User(txtFieldUsername.getText(),
           txtFieldFirstname.getText(),
           txtFieldLastname.getText(),
           textFieldTelephoneNumber.getText(),
           newAddress,
           ZonedDateTime.now(),
          "profile-pics/1.png"
           );
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


         }else{
           if(txtFieldUsername.getText().isEmpty()){
             lblErrorUsername.setText("Username is compulsory");
           }
           if(txtFieldPostcode.getText().isEmpty()){
             lblErrorPostcode.setText("Postcode is compulsory");
           }
           if(textFieldTelephoneNumber.getText().isEmpty()){
             lblErrorTelephoneNumber.setText("Telephone number is compulsory");
           }
           if(txtFieldFirstname.getText().isEmpty()){
             lblErrorFirstname.setText("First Name is compulsory");
           }if(txtFieldLastname.getText().isEmpty()){
             lblErrorLastname.setText("Last Name is compulsory");
           }if(txtFieldAddressLine1.getText().isEmpty()){
             lblErrorAddressLine1.setText("Address line one is compulsory");
           }if(txtFieldTownOrCity.getText().isEmpty()){
             lblErrorTownOrCity.setText("Town or city is compulsory");
           }
         }
    }



    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

}
