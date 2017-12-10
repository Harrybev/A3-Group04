import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.layout.RowConstraints;
import java.io.IOException;
import javafx.geometry.Insets;

public class MyAuctionsController {
    @FXML Label lblName;
    @FXML Label lblDesc;
    //@FXML Pane paneArtwork;
    @FXML AnchorPane paneAnchorPane;

    ArrayList<Auction> auctionsList = Filter.currentUserAuctions(
            DataController.getAuctionTree
            (), DataController.getLoggedInUser());

    public void initialize() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        RowConstraints row = new RowConstraints(300);

      if(auctionsList.isEmpty()){
        System.out.println("No Auctions");
      }

      //gridPane.setAlignment(Pos.CENTER);

      paneAnchorPane.getChildren().add(gridPane);

      //gridPane.add(test,0,0);
      int x = 0;
      int y = 0;
      for(Auction auction : auctionsList){

        if(x==5){
          y=y+1;
          y=0;
        }
        try{
          GridPane gridPaneInside = new GridPane();
          gridPaneInside.setAlignment(Pos.TOP_LEFT);
          gridPaneInside.setHgap(10);
          gridPaneInside.setVgap(10);
          gridPaneInside.setPadding(new Insets(25, 25, 25, 25));

          if(!(auction.isHasEnded())){
            Label newArtName = new Label(auction.getArtwork().getTitle());

            Label newArtDesc = new Label(auction.getArtwork().getDescription());

            Image newImage = new Image(auction.getArtwork().getPhotoPath());
            ImageView newImageView = new ImageView();
            newImageView.setImage(newImage);
            newImageView.setFitHeight(100);
            newImageView.setFitWidth(100);

            gridPaneInside.add(newImageView,0,0);
            gridPaneInside.add(newArtName,0,1);
            gridPaneInside.add(newArtDesc,0,2);

            gridPaneInside.setOnMouseClicked(e -> {
              System.out.printf("Mouse Clicked on "+auction.getArtwork().getTitle());
            });
            gridPane.add(gridPaneInside,x,y);
          }else{

        }}catch(ClassCastException e){
          System.out.println(e);
          break;
        }


        x=x+1;
      }



    }


}
