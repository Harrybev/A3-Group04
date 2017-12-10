import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
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
import javafx.stage.WindowEvent;

import java.io.IOException;
public class MainController{

  @FXML ScrollPane changePane;
  @FXML Label lblWelcome;

  private Stage previousStage;
  private User loggedInUser = DataController.getLoggedInUser();

  public void initialize(){
    lblWelcome.setText("Welcome: "+ loggedInUser.getUsername());
  }

  @FXML
  public void handleBtnMyAuction(){
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
              ("MyAuctions.fxml"));

      AnchorPane viewAuctionsRoot = (AnchorPane) fxmlLoader.load();
      changePane.setContent(viewAuctionsRoot);

    } catch (IOException e) {
      e.printStackTrace();
    }
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

  @FXML
  public  void handleBtnProfileSettings(ActionEvent event) {
      try {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                  ("ProfileSettings.fxml"));

        BorderPane profileSettingsRoot = (BorderPane) fxmlLoader.load();

        ProfileSettingsController profileSettingsController = fxmlLoader
              .<ProfileSettingsController>getController();


        Stage mainStage = (Stage) lblWelcome.getScene().getWindow();

        Scene profileSettingsScene = new Scene(profileSettingsRoot);
        Stage profileSettingsStage = new Stage();
        profileSettingsStage.setScene(profileSettingsScene);
        profileSettingsStage.setTitle(Main.WINDOW_TITLE);

        // Displays Login Window again when AuctionView closes
        profileSettingsStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              mainStage.show();
          }
         });

        profileSettingsStage.initModality(Modality.APPLICATION_MODAL);


        mainStage.close();
        profileSettingsStage.show();


      } catch (IOException e) {
          e.printStackTrace();

          System.exit(-1);
      }
  }

  public void setPreviousStage(Stage previousStage) {
      this.previousStage = previousStage;
  }

}
