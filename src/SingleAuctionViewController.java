import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;


public class SingleAuctionViewController {

    @FXML Label lblArtworkDetails;
    @FXML Pane paneDynamicBidOrHistory;
    @FXML ImageView ivAuctionImage;
    @FXML TextField txtBidAmount;
    @FXML Label lblSellerName;
    @FXML Label lblBidValue;
    @FXML Button btnBid;
    @FXML Label lblHighestBidder;

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
        Double doubleBidAmount = (Double) selectedAuction.getNewBidMinimum();

        this.lblBidValue.setText("£" + Double.toString(doubleBidAmount));

        if (checkHighestBidder()) {
            this.lblHighestBidder.setText("You are the highest bidder for " +
                    "this item.");
        } else {
            this.lblHighestBidder.setText("");
        }

    }

    private void handleBtnBid() {

        if (!validateBidAmount()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Bid field empty");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a value.");
            alert.showAndWait();
        } else if (!checkHighestBidder()) {
            if (Double.parseDouble(txtBidAmount.getText()) > selectedAuction
                    .getNewBidMinimum()) {
                Double bidAmount = Double.parseDouble(txtBidAmount.getText());

                Bid newBid = new Bid(bidAmount, DataController.getLoggedInUser(),
                        LocalDateTime.now());
                selectedAuction.placeBid(newBid);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Bid successful!");
                alert.setHeaderText(null);
                alert.setContentText("You have successfully bidded on " +
                        selectedAuction.getArtwork().getTitle());
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Insufficient bid amount");
                alert.setHeaderText(null);
                alert.setContentText("Your bid must exceed the latest bid.");
                alert.showAndWait();
                return;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Unnecessary bid");
                alert.setHeaderText(null);
                alert.setContentText("You are already the highest bidder on " +
                        "this item.");
                alert.showAndWait();
                return;
        }

    }

    private boolean checkHighestBidder() {
        if (selectedAuction.getBidList().size() == 0) {
           return false;
        } else if (selectedAuction.getLatestBid().getBidder() == DataController
                .getLoggedInUser()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateBidAmount() {
        if (txtBidAmount.getText().equals("")) {
            return false;
        }

        try {
            Double.parseDouble(txtBidAmount.getText());
        } catch (NumberFormatException e){
            return false;
        }

        return true;
    }
}
