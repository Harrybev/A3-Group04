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
      System.out.println(telephoneNumber);
      Matcher match = telephonePattern.matcher(telephoneNumber);
      System.out.println(match.matches());
      if(match.matches()){
        lblErrorTelephoneNumber.setText("Valid Number");
      }else{
        lblErrorTelephoneNumber.setText("Invalid Number");
      }
    }

    @FXML public void validateFieldPostcode(){
      String postCode = txtFieldPostcode.getText().replaceAll("\\s+","");
      Matcher match = postcodePattern.matcher(postCode);
      if(match.matches()){
        lblErrorPostcode.setText("Valid Postcode");
      }else{
        lblErrorPostcode.setText("Invalid Postcode");
      }
    }

    @FXML public void handleToLogin(){


    }

    @FXML public void handleBtnCreateAccount(){
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
           " "
           );
           BSTNode newNode = new BSTNode(newUser);
           DataController.getUserTree().addNode(newNode);
         }else{
           System.out.println("handle erros");
         }
    }



    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }

}
