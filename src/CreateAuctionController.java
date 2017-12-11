import java.lang.Exception;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateAuctionController {

    @FXML TextField txtTitle;
    @FXML ComboBox cboType;
    @FXML TextField txtDescription;
    @FXML TextField txtCreatorName;
    @FXML TextField txtYear;
    @FXML TextField txtWidth;
    @FXML TextField txtHeight;
    @FXML TextField txtDepth;
    @FXML TextField txtMaterial;
    @FXML TextField txtBidNum;
    @FXML TextField txtReservePrice;
    @FXML TextField txtImagePath;
    @FXML Button btnSelectImage;
    @FXML Button btnListAuction;

    ArrayList<String> additionalPhotosList = new ArrayList<>();


    public void initialize() {


        cboType.getItems().addAll("Painting", "Sculpture");


        btnSelectImage.setOnAction(event -> {
            selectImage();
        });

        btnListAuction.setOnAction(event -> {
            createArtwork();
        });


    }

    private void selectImage() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Select an image");
        try {

            File initialFile = new File(".");
            fc.setInitialDirectory(initialFile);
            List<File> fileList = fc.showOpenMultipleDialog(new Stage());

            String name = fileList.get(0).getName();

            txtImagePath.setText("artwork-pics/" + fileList.get(0).getName());

            if (fileList.size() > 1) {
                for (int i = 1; i < fileList.size(); i++) {
                    additionalPhotosList.add("artwork-pics/"+ fileList.get(i)
                            .getName());
                }
            }
        } catch (NullPointerException e) {
            txtImagePath.setText("");
        }
        for (String s : additionalPhotosList) {
            System.out.println(s);
        }
    }

    private void createArtwork() {
        if (validateFields()) {
            String title = txtTitle.getText().replace(";","");
            String type = cboType.getValue().toString().replace(";","");
            String description = txtDescription.getText().replace(";","");
            String photoPath = txtImagePath.getText();
//            String photoPath = txtImagePath.getText().replace(";","");
            String creatorName = txtCreatorName.getText().replace(";","");
            int yearCreated = (int) Integer.parseInt(txtYear.getText());
            double width = (double) Double.parseDouble(txtWidth.getText());
            double height = (double) Double.parseDouble(txtHeight.getText());



            if (type.equals("Painting")) {
                Painting painting = new Painting(title, type, description,
                        photoPath, creatorName, yearCreated, width, height);
                listAuction(painting);
            } else {
                double depth = (double) Double.parseDouble(txtDepth.getText());
                String material = txtMaterial.getText().replace(";","");
                Sculpture sculpture = new Sculpture(title, type, description,
                        photoPath, creatorName, yearCreated, width, height,
                        depth, material, additionalPhotosList);
                listAuction(sculpture);
            }
        }
    }

    private boolean validateFields() {
        try {
            Integer validateYear = Integer.parseInt(txtYear.getText());
            Double validateWidth = Double.parseDouble(txtWidth.getText());
            Double validateHeight = Double.parseDouble(txtHeight.getText());
            Integer validateNumBids = Integer.parseInt(txtBidNum.getText());
            Double validateReservePrice = Double.parseDouble(txtReservePrice
                    .getText());
        } catch (Exception e) {
            return false;
        }

        ArrayList<TextField> validateList = new ArrayList<>();
        validateList.add(txtTitle);
        validateList.add(txtDescription);
        validateList.add(txtCreatorName);
        validateList.add(txtYear);
        validateList.add(txtWidth);
        validateList.add(txtHeight);
        validateList.add(txtBidNum);
        validateList.add(txtReservePrice);
        validateList.add(txtImagePath);

        for (TextField tf : validateList) {
            if (tf.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Field blank");
                alert.setHeaderText(null);
                alert.setContentText("Please complete all fields.");
                alert.showAndWait();
                return false;
            }
        }

        if (cboType.getValue().toString().equals("Sculpture")) {
            try {
                Double validateDepth = Double.parseDouble(txtDepth.getText());
            } catch (Exception e) {
                return false;
            }
            if (txtDepth.getText().equals("") || txtMaterial.getText().equals
                    ("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Field blank");
                alert.setHeaderText(null);
                alert.setContentText("Please complete all fields.");
                alert.showAndWait();
                return false;
            }
        }

        return true;
    }

    private void listAuction(Artwork artwork) {
        int numberOfBids = (int) Integer.parseInt(txtBidNum.getText());
        double reservePrice = (double) Double.parseDouble(txtReservePrice
                    .getText());

        Auction auction = new Auction(DataController.getLoggedInUser(),
                artwork,numberOfBids,reservePrice,false);
        BSTNode artNode = new BSTNode(artwork);
        BSTNode auctionNode = new BSTNode(auction);
        DataController.getArtTree().addNode(artNode);
        DataController.getAuctionTree().addNode(auctionNode);
    }
}
