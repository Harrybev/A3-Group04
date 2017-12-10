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

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ViewAuctionsController {
    @FXML Label lblName;
    @FXML Label lblDesc;
    //@FXML Pane paneArtwork;
    @FXML AnchorPane paneAnchorPane;

    ArrayList<Sortable> auctionsList = DataController.getAuctionTree().inOrderList();

    public void initialize() {


      for(Sortable sortable : auctionsList){
        try{
          Auction auction = (Auction) sortable;
        }catch(ClassCastException e){
          System.out.println(e);
        }



      }

    }


}
