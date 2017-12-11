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
import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.layout.RowConstraints;
import java.io.IOException;
import javafx.geometry.Insets;
import java.util.Iterator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class MyAuctionsController {
    @FXML Label lblName;
    @FXML Label lblDesc;
    //@FXML Pane paneArtwork;
    @FXML AnchorPane paneAnchorPane;
    @FXML ChoiceBox choiceBoxFilter;
    GridPane gridPane;
    ObservableList<String> cursors = FXCollections.observableArrayList("All","Sculpture","Painting");
    ArrayList<Auction> auctionsList = Filter.currentUserAuctions(DataController.getAuctionTree(), DataController.getLoggedInUser());



    public void applyFilter(){
    choiceBoxFilter.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    @Override public void changed(ObservableValue<? extends String> selected, String oldPick, String newPick) {
      if (newPick != null) {



        if(auctionsList.isEmpty()){
          System.out.println("No Auctions");
          return;
        }
        for(Iterator<Auction> i = auctionsList.iterator(); i.hasNext();){
            Auction auction = i.next();
            if(choiceBoxFilter.getValue().equals("Sculpture") && !(auction.getArtwork() instanceof Sculpture)){
              i.remove();
            }else if(choiceBoxFilter.getValue().equals("Painting") && !(auction.getArtwork() instanceof Painting)){
              i.remove();
            }else{
            }
        }




        populateGrid();
        }
      }
      });
    }






    public void initialize() {
      choiceBoxFilter.setItems(cursors);
      choiceBoxFilter.setValue("All");
      gridPane = new GridPane();
      gridPane.setAlignment(Pos.TOP_LEFT);
      gridPane.setHgap(10);
      gridPane.setVgap(10);
      gridPane.setPadding(new Insets(25, 25, 25, 25));

      RowConstraints row = new RowConstraints(300);


      //gridPane.setAlignment(Pos.CENTER);

      paneAnchorPane.getChildren().add(gridPane);
      applyFilter();
      populateGrid();


    }
    void populateGrid(){
      gridPane.getChildren().clear();
      int x = 0;
      int y = 0;
      for(Auction auction : auctionsList){
        if(x %4 == 0){
          y=y+1;
          x=0;
        }
        try{
          if(!(auction.isHasEnded())){
            System.out.println("gridPaneCreated"+auction.getArtwork().getTitle());
            GridPane gridPaneInside = new GridPane();
            gridPaneInside.setAlignment(Pos.TOP_LEFT);
            gridPaneInside.setHgap(10);
            gridPaneInside.setVgap(10);
            gridPaneInside.setPadding(new Insets(25, 25, 25, 25));
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

            gridPane.add(gridPaneInside,x,y);
            x++;
          }else{

        }}catch(ClassCastException e){
          System.out.println(e);
          break;
        }



      }
      auctionsList = Filter.currentUserAuctions(DataController.getAuctionTree(),
              DataController.getLoggedInUser());
    }

  }
