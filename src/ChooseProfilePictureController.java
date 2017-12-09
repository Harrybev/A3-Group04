import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseProfilePictureController {
    @FXML StackPane stackPane1;
    @FXML StackPane stackPane2;
    @FXML StackPane stackPane3;
    @FXML StackPane stackPane4;
    @FXML StackPane stackPane5;
    @FXML StackPane stackPane6;
    @FXML StackPane stackPane7;
    @FXML StackPane stackPane8;

    @FXML ImageView iv1;
    @FXML ImageView iv2;
    @FXML ImageView iv3;
    @FXML ImageView iv4;
    @FXML ImageView iv5;
    @FXML ImageView iv6;
    @FXML ImageView iv7;
    @FXML ImageView iv8;
    @FXML Button btnDraw;

    private boolean userHasCustomPic = false;
    private ArrayList<StackPane> stackPaneBorderState = new ArrayList<>();
    private DropShadow dropShadow = new DropShadow(20, Color.PURPLE);

    public void initialize() {

        Image image1 = new Image("profile-pics/1.jpg");
        Image image2 = new Image("profile-pics/2.jpg");
        Image image3 = new Image("profile-pics/3.jpg");
        Image image4 = new Image("profile-pics/4.jpg");
        Image image5 = new Image("profile-pics/5.jpg");
        Image image6 = new Image("profile-pics/6.jpg");
        Image image7 = new Image("profile-pics/7.jpg");

        iv1.setImage(image1);
        iv2.setImage(image2);
        iv3.setImage(image3);
        iv4.setImage(image4);
        iv5.setImage(image5);
        iv6.setImage(image6);
        iv7.setImage(image7);

        try {
            Image customImage = new Image("profile-pics/" + DataController.getLoggedInUser().getUsername() + ".jpg");
            iv8.setImage(customImage);
            userHasCustomPic = true;
        } catch (IllegalArgumentException e) {
            Image customImage = new Image("profile-pics/drawyourown.jpg");
            iv8.setImage(customImage);
        }

        stackPaneBorderState.add(stackPane1);
        stackPaneBorderState.add(stackPane2);
        stackPaneBorderState.add(stackPane3);
        stackPaneBorderState.add(stackPane4);
        stackPaneBorderState.add(stackPane5);
        stackPaneBorderState.add(stackPane6);
        stackPaneBorderState.add(stackPane7);
        stackPaneBorderState.add(stackPane8);

        btnDraw.setOnAction(event -> {
            handleBtnDraw();
        });

        iv1.setOnMouseClicked(event -> {
            handleImageViewer1Click();
        });

        iv2.setOnMouseClicked(event -> {
            handleImageViewer2Click();
        });

        iv3.setOnMouseClicked(event -> {
            handleImageViewer3Click();
        });
        iv4.setOnMouseClicked(event -> {
            handleImageViewer4Click();
        });
        iv5.setOnMouseClicked(event -> {
            handleImageViewer5Click();
        });
        iv6.setOnMouseClicked(event -> {
            handleImageViewer6Click();
        });
        iv7.setOnMouseClicked(event -> {
            handleImageViewer7Click();
        });

        iv8.setOnMouseClicked(event -> {
            handleImageViewer8Click();
        });




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

            Stage profileSettingsStage = (Stage) btnDraw.getScene().getWindow();

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

    public void handleImageViewer1Click() {
        DataController.getLoggedInUser().setProfileImagePath
                ("profile-pics/1.jpg");
        toggleImageBorders(stackPane1);
    }

    public void handleImageViewer2Click() {
        DataController.getLoggedInUser().setProfileImagePath
                ("profile-pics/2.jpg");
        toggleImageBorders(stackPane2);
    }

    public void handleImageViewer3Click() {
        DataController.getLoggedInUser().setProfileImagePath
                ("profile-pics/3.jpg");
        toggleImageBorders(stackPane3);
    }

    public void handleImageViewer4Click() {
        DataController.getLoggedInUser().setProfileImagePath
                ("profile-pics/4.jpg");
        toggleImageBorders(stackPane4);
    }

    public void handleImageViewer5Click() {
        DataController.getLoggedInUser().setProfileImagePath
                ("profile-pics/5.jpg");
        toggleImageBorders(stackPane5);
    }

    public void handleImageViewer6Click() {
        DataController.getLoggedInUser().setProfileImagePath
                ("profile-pics/6.jpg");
        toggleImageBorders(stackPane6);
    }

    public void handleImageViewer7Click() {
        DataController.getLoggedInUser().setProfileImagePath
                ("profile-pics/7.jpg");
        toggleImageBorders(stackPane7);
    }

    public void handleImageViewer8Click() {
        if (userHasCustomPic == true) {
            DataController.getLoggedInUser().setProfileImagePath("profile-pics/"
                    + DataController.getLoggedInUser().getUsername() + ".jpg");
        } else {
            DataController.getLoggedInUser().setProfileImagePath
                ("profile-pics/drawyourown.jpg");
        }
        toggleImageBorders(stackPane8);
    }

    private void toggleImageBorders(StackPane clickedStackPane) {
        for (StackPane sp : stackPaneBorderState) {
            if (sp != clickedStackPane) {
                sp.setStyle("-fx-background-color: black");
            } else {
                sp.setStyle("-fx-background-color: white");
            }
        }
    }


}
