import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

/**
 * The main class for this program.
 * @author Christopher Evans
 *
 */
public class Main extends Application {

    public static final int MAIN_WINDOW_WIDTH = 900;
    public static final int MAIN_WINDOW_HEIGHT = 600;
    public static final String WINDOW_TITLE = "Artatawe";

//    public static final int EDIT_WINDOW_WIDTH = 400;
//    public static final int EDIT_WINDOW_HEIGHT = 250;
//    public static final String EDIT_WINDOW_TITLE = "Edit Europe";

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the main scene.
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().
                    getResource("LoginForm.fxml"));
            Scene scene = new Scene(root, MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT);

            // Place the main scene on stage and show it.
            primaryStage.setScene(scene);
            primaryStage.setTitle(WINDOW_TITLE);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);

    }
}