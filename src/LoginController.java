import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML Button btnLogin;
    @FXML TextField txtUsername;

    private BST userTree = new BST();
    private BST artTree = new BST();
    private BST auctionTree = new BST();

    // Initialises the controller and apparently gets called automatically
    public void initialize() {
        userTree = ReadFiles.readUsers();
        artTree = ReadFiles.readArtworks();
        auctionTree = ReadFiles.readAuctions(userTree, artTree);

        // Setup actions on controls
        btnLogin.setOnAction(event -> {
            handleBtnLoginAction();
        });
    }

    private void handleBtnLoginAction() {
        if (userTree.searchBST(txtUsername.getText()) == null) {
            System.out.println("Username does not exist!");
        } else {
            System.out.println("Login successful!");
        }
    }



}
