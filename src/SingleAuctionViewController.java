import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class SingleAuctionViewController {

    @FXML Label lblArtworkDetails;
    @FXML Pane paneDynamicBidOrHistory;
    @FXML ImageView ivAuctionImage;

    private Auction selectedAuction;


    public void initialize() {



    }

    public void setSelectedAuction(Auction selectedAuction) {
       this.selectedAuction = selectedAuction;
       refreshImageView();
    }

    private void refreshImageView() {
        Image image = new Image(selectedAuction.getArtwork().getPhotoPath());
        System.out.println(selectedAuction.getArtwork().getTitle());
        this.ivAuctionImage.setImage(image);
    }
}
