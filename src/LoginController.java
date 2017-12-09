import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class LoginController {
    @FXML Button btnLogin;
    @FXML TextField txtUsername;
    @FXML Hyperlink hyplinkCreateAccount;

    private DataController data;

    // Initialises the controller and apparently gets called automatically
    public void initialize() {

        BST userTree = ReadFiles.readUsers();
        BST artTree = ReadFiles.readArtworks();
        BST auctionTree = ReadFiles.readAuctions(userTree, artTree);
        DataController.setUserTree(userTree);
        DataController.setArtTree(artTree);
        DataController.setAuctionTree(auctionTree);

        // Setup actions on controls
        btnLogin.setOnAction(event -> {
            handleBtnLoginAction();
        });
    }

    @FXML
    private void handleHyplinkCreateAccount(ActionEvent event)  throws Exception {
      try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                  ("AccountCreation.fxml"));

          BorderPane accountCreationRoot = (BorderPane) fxmlLoader.load();

          AccountCreationController accountCreationController = fxmlLoader
                  .<AccountCreationController>getController();


          Stage loginStage = (Stage) btnLogin.getScene().getWindow();
          accountCreationController.setPreviousStage(loginStage);

          Scene accountCreationScene = new Scene(accountCreationRoot,
                  Main.MAIN_WINDOW_WIDTH, Main.MAIN_WINDOW_HEIGHT);

          Stage accountCreationStage = new Stage();
          accountCreationStage.setScene(viewAuctionsScene);
          viewAuctionsStage.setTitle(Main.WINDOW_TITLE);

          // Displays Login Window again when AuctionView closes
          viewAuctionsStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
              public void handle(WindowEvent we) {
                  loginStage.show();
              }
          });

          viewAuctionsStage.initModality(Modality.APPLICATION_MODAL);


          loginStage.close();
          viewAuctionsStage.show();


      } catch (IOException e) {
          e.printStackTrace();

          System.exit(-1);
      }
    }


    

    private void handleBtnLoginAction() {
        if (DataController.getUserTree().searchBST(txtUsername.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Username not found");
            alert.setHeaderText(null);
            alert.setContentText("Please enter another username.");
            alert.showAndWait();
            return;
        } else {
            // stores the currently logged in user
            DataController.setLoggedInUser((User) data.getUserTree().searchBST
                    (txtUsername.getText()).getSortable());

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                        ("ViewAuctions.fxml"));

                AnchorPane viewAuctionsRoot = (AnchorPane) fxmlLoader.load();

                ViewAuctionsController viewAuctionController = fxmlLoader
                        .<ViewAuctionsController>getController();


                Stage loginStage = (Stage) btnLogin.getScene().getWindow();
                viewAuctionController.setPreviousStage(loginStage);

                Scene viewAuctionsScene = new Scene(viewAuctionsRoot,
                        Main.MAIN_WINDOW_WIDTH, Main.MAIN_WINDOW_HEIGHT);

                Stage viewAuctionsStage = new Stage();
                viewAuctionsStage.setScene(viewAuctionsScene);
                viewAuctionsStage.setTitle(Main.WINDOW_TITLE);

                // Displays Login Window again when AuctionView closes
                viewAuctionsStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                        loginStage.show();
                    }
                });

                viewAuctionsStage.initModality(Modality.APPLICATION_MODAL);


                loginStage.close();
                viewAuctionsStage.show();


            } catch (IOException e) {
                e.printStackTrace();

                System.exit(-1);
            }
        }

    }

    public void setDataController(DataController data) {
        this.data = data;
    }



}
