import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;
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
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
public class MainController{

  @FXML ScrollPane changePane;
  @FXML Label lblWelcome;

  private Stage previousStage;
  private User loggedInUser = DataController.getLoggedInUser();

  public void initialize(){
    lblWelcome.setText("Welcome: "+loggedInUser.getUsername());
  }

  @FXML
  public void handleBtnMyAuction(){


  }
  @FXML
  public void handleBtnCompletedAuctions(){

  }
  @FXML
  public void handleBtnWonArt(){

  }
  @FXML
  public void handleBtnBidHistory(){

  }
  @FXML
  public void handleBtnAuctions(ActionEvent event){
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
              ("ViewAuctions.fxml"));

      AnchorPane viewAuctionsRoot = (AnchorPane) fxmlLoader.load();
      changePane.setContent(viewAuctionsRoot);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void setPreviousStage(Stage previousStage) {
      this.previousStage = previousStage;
  }

}
