import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class DrawPanelController {

    @FXML Button btnSave;

    public void initialize() {

//        btnDraw.setOnAction(event -> {
//            handleBtnDraw();
//        });
    }

    public void handleBtnDraw() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                    ("DrawPanelController.fxml"));

            BorderPane drawPanelRoot = (BorderPane) fxmlLoader.load();

            DrawPanelController drawPanelController = fxmlLoader
                    .<DrawPanelController>getController();

            Scene drawPanelScene = new Scene(drawPanelRoot,
                    Main.MAIN_WINDOW_WIDTH, Main.MAIN_WINDOW_HEIGHT);

            Stage drawPanelStage = new Stage();
            drawPanelStage.setScene(drawPanelScene);
            drawPanelStage.setTitle(Main.WINDOW_TITLE);
            drawPanelStage.initModality(Modality.APPLICATION_MODAL);

            Stage profileSettingsStage = (Stage) btnSave.getScene().getWindow();

            drawPanelStage.setOnCloseRequest(new EventHandler<
                                            WindowEvent>() {
                public void handle(WindowEvent we) {
                    profileSettingsStage.show();
                }
            });

            profileSettingsStage.close();
            drawPanelStage.show();

        } catch (IOException e) {
            e.printStackTrace();

            System.exit(-1);
        }
    }
}
