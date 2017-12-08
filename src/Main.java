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

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the main scene.
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().
                    getResource("LoginForm.fxml"));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                        ("LoginController.fxml"));

            Scene loginFormScene = new Scene(root, Main.MAIN_WINDOW_WIDTH,
                    Main.MAIN_WINDOW_HEIGHT);

            Stage loginStage = new Stage();
            loginStage.setScene(loginFormScene);

            loginStage.setTitle(Main.WINDOW_TITLE);
            loginStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        BST userTree = ReadFiles.readUsers();
//        BST artTree = ReadFiles.readArtworks();
//        BST auctionTree = ReadFiles.readAuctions(userTree, artTree);
//        DataController data = new DataController(userTree, artTree,
//                auctionTree);
//
//        User testUser = (User) userTree.searchBST("blerg").getSortable();
//
//        for (User user : testUser.getFavouriteUsers()) {
//            System.out.println(user.getUsername());
//        }

        launch(args);

    }
}