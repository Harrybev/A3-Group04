import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
public class Main2 extends Application {
    public static final String WINDOW_TITLE = "Artatawe";

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the main scene.
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().
                    getResource("Main.fxml"));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource
                        ("Main.fxml"));

            Scene mainScene = new Scene(root);

            Stage MainStage = new Stage();
            MainStage.setScene(mainScene);

            MainStage.setTitle(Main.WINDOW_TITLE);
            MainStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        BST userTree = ReadFiles.readUsers();
//        BST artTree = ReadFiles.readArtworks();
//        BST auctionTree = ReadFiles.readAuctions(userTree, artTree);
//        DataController.setUserTree(userTree);
//        DataController.setArtTree(artTree);
//        DataController.setAuctionTree(auctionTree);


//        User testUser = (User) userTree.searchBST("blerg").getSortable();
//        for (User user : testUser.getFavouriteUsers()) {
//            System.out.println(user.getUsername());        }

      launch(args);

    }
}
