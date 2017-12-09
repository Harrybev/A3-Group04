import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ViewAuctionsController {
    @FXML Label lblLoggedInUser;
    @FXML Hyperlink lnkProfilePage;

    private DataController data;
    private Stage previousStage;

    public void initialize() {


        lnkProfilePage.setOnAction(event -> {
            handleLnkProfilePageAction();
        });

    }

    @FXML
    public void handleLnkProfilePageAction() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                    ("ProfileSettings.fxml"));

            BorderPane viewProfileSettingsRoot = (BorderPane) fxmlLoader.load();

            ProfileSettingsController profileSettingsController = fxmlLoader
                    .<ProfileSettingsController>getController();

            Scene profileSettingsScene = new Scene(viewProfileSettingsRoot,
                    Main.MAIN_WINDOW_WIDTH, Main.MAIN_WINDOW_HEIGHT);

            Stage profileSettingsStage = new Stage();
            profileSettingsStage.setScene(profileSettingsScene);
            profileSettingsStage.setTitle(Main.WINDOW_TITLE);
            profileSettingsStage.initModality(Modality.APPLICATION_MODAL);

            Stage viewAuctionsStage = (Stage) lnkProfilePage.getScene().
                    getWindow();
            // Displays Login Window again when AuctionView closes
            profileSettingsStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    viewAuctionsStage.show();
                }
            });


            viewAuctionsStage.close();
            profileSettingsStage.show();

        } catch (IOException e) {
            e.printStackTrace();

            System.exit(-1);
        }


    }

    public void setDataController(DataController data) {
        this.data = data;
    }

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }
}
