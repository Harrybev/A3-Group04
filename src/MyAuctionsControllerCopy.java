import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class MyAuctionsControllerCopy {
    @FXML Label lblName;
    @FXML Label lblDesc;
    //@FXML Pane paneArtwork;
    @FXML AnchorPane paneAnchorPane;
    @FXML ChoiceBox choiceBoxFilter;
    GridPane gridPane;
    ObservableList<String> cursors = FXCollections.observableArrayList("All","Sculpture","Painting");
    ArrayList<Auction> auctionsList = Filter.currentUserAuctions(
              DataController.getAuctionTree
              (), DataController.getLoggedInUser());
    ArrayList<Auction> filteredList = new ArrayList<>();
    String filterSetting = "All";



    public ArrayList<Auction> applyFilter(ArrayList<Auction> unfilteredList){
        ArrayList<Auction> filteredList = new ArrayList<>();

        for (Auction auction : unfilteredList) {
            if (auction.getArtwork().getType().equals(filterSetting)) {
                filteredList.add(auction);
            }
        }
        return filteredList;
    }

    public void initialize() {

        choiceBoxFilter.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener() {
            @Override
             public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                 filterSetting = choiceBoxFilter.getValue().toString();
                 populateGrid();
             }
         });


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
      populateGrid();

      //gridPane.add(test,0,0);



    }
    private void populateGrid(){
      gridPane.getChildren().clear();
      filteredList = applyFilter(auctionsList);

      int x = 0;
      int y = 0;
      for(Auction auction : filteredList){
        if(x%4==0){
          y=y+1;
          x=0;
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


        x++;
      }
//      auctionsList = Filter.currentUserAuctions(DataController.getAuctionTree(),
//              DataController.getLoggedInUser());
    }

}
