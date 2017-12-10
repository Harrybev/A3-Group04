import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import javax.swing.text.html.ImageView;

public class SingleAuctionViewController {

    @FXML
    Label lblArtworkDetails;
    Pane paneDynamicBidOrHistory;
    ImageView ivAuctionImage;


    private Auction selectedAuction;

    public void initialize() {


    }

    public void setSelectedAuction(Auction selectedAuction) {
        this.selectedAuction = selectedAuction;
    }
}
