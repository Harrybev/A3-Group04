import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    @FXML TextField txtBidAmount;
    @FXML Label lblSellerName;
    @FXML Label lblBidValue;
    @FXML Button btnBid;

    private Auction selectedAuction;


    public void initialize() {

        btnBid.setOnAction(event -> {
            handleBtnBid();
        });

    }

    public void setSelectedAuction(Auction selectedAuction) {
       this.selectedAuction = selectedAuction;
       displayArtDetails();
       displayAuctionDetails();
    }

    private void displayArtDetails() {
        Image image = new Image(selectedAuction.getArtwork().getPhotoPath());
        String title = "Title: " + selectedAuction.getArtwork().getTitle() +
                "\n";
        String type = "Type: " + selectedAuction.getArtwork().getType() + "\n";
        String description = "Description: " + selectedAuction.getArtwork()
                .getDescription() + "\n";
        String creatorName = "Creator: " + selectedAuction.getArtwork()
                .getCreatorName() + "\n";
        Integer intCreationYear = (Integer) selectedAuction.getArtwork()
                .getCreationYear();
        String creationYear = "Creation year: " + intCreationYear.toString();

        String auctionDetails = title + type + description + creatorName +
                creationYear;
        this.ivAuctionImage.setImage(image);
        this.lblArtworkDetails.setText(auctionDetails);
    }

    private void displayAuctionDetails() {
        this.lblSellerName.setText(selectedAuction.getSeller().getUsername()
                .toString());
        Double doubleBidAmount = (Double) selectedAuction.getLatestBid()
                .getBidAmount();
        this.lblBidValue.setText("£" + Double.toString(doubleBidAmount));
    }

    private void handleBtnBid() {
        if (Double.parseDouble(txtBidAmount.getText()) > selectedAuction
                .getLatestBid().getBidAmount()) {
            System.out.println("Bid successful");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient bid amount");
            alert.setHeaderText(null);
            alert.setContentText("Your bid must exceed the latest bid.");
            alert.showAndWait();
            return;
        }

    }
}
