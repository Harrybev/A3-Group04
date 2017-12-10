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

import java.io.IOException;

public class ViewAuctionsController {
    @FXML Label lblName;
    @FXML Label lblDesc;
    //@FXML Pane paneArtwork;
    @FXML AnchorPane paneAnchorPane;

    ArrayList<Sortable> auctionsList = DataController.getAuctionTree().inOrderList();

    public void initialize() {
        GridPane gridPane = new GridPane();
        gridPane.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
        Node source = (Node)e.getSource() ;
        Integer colIndex = gridPane.getColumnIndex(source);
        Integer rowIndex = gridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
      });



      if(auctionsList.isEmpty()){
        System.out.println("No Auctions");
      }

      gridPane.setAlignment(Pos.CENTER);

      paneAnchorPane.getChildren().add(gridPane);

      //gridPane.add(test,0,0);
      int x = 0;
      int y = 0;
      for(Sortable sortable : auctionsList){
        if(x==3){
          y=y+1;
          y=0;
        }

        try{
          Auction auction = (Auction) sortable;
          Label newArtName = new Label(auction.getArtwork().getTitle());
          Label newArtDesc = new Label(auction.getArtwork().getDescription());
          Image newImage = new Image(auction.getArtwork().getPhotoPath());
          ImageView newImageView = new ImageView();
          newImageView.setImage(newImage);
          newImageView.setFitHeight(100);
          newImageView.setFitWidth(100);

          gridPane.add(newArtName,x,y);
          gridPane.add(newArtDesc,x,y);
          gridPane.add(newImageView,x,y);


        }catch(ClassCastException e){
          System.out.println(e);
          break;
        }


        x=x+1;
      }

    }


}
