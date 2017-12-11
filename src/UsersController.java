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
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ButtonBase;


public class UsersController {

    //@FXML Pane paneArtwork;
    @FXML AnchorPane paneAnchorPane;
    @FXML ChoiceBox choiceBoxFilter;
    GridPane gridPane;
    ObservableList<String> cursors = FXCollections.observableArrayList("All","Favourites");
    ArrayList<Sortable> userList = DataController.getUserTree().inOrderList();



    public void applyFilter() {
    choiceBoxFilter.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    @Override public void changed(ObservableValue<? extends String> selected, String oldPick, String newPick) {
        if (newPick != null) {

        if(choiceBoxFilter.getValue().equals("Favourites")){
          populateGrid(true);
        } else{
          populateGrid(false);
        }
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
      //applyFilter();
      populateGrid(false);


    }
    void populateGrid(Boolean filter){
      gridPane.getChildren().clear();
      int x = 0;
      int y = 0;
      for(Sortable user : userList){
        User userType = (User) user;
        if(x %4 == 0){
          y=y+1;
          x=0;
        }
        try{
          if(!(userType.equals(DataController.getLoggedInUser()))){
            GridPane gridPaneInside = new GridPane();
            gridPaneInside.setAlignment(Pos.TOP_LEFT);
            gridPaneInside.setHgap(10);
            gridPaneInside.setVgap(10);
            gridPaneInside.setPadding(new Insets(25, 25, 25, 25));
            Label newUsername = new Label(userType.getUsername());

            Image newImage = new Image(userType.getProfileImagePath());
            ImageView newImageView = new ImageView();
            newImageView.setImage(newImage);
            newImageView.setFitHeight(100);
            newImageView.setFitWidth(100);
            CheckBox favourites = new CheckBox("Favourite");
            if(DataController.getLoggedInUser().isFavourites(userType)) {
              favourites.setSelected(true);
            }
            gridPaneInside.add(newImageView,0,0);
            gridPaneInside.add(newUsername,0,1);
            gridPaneInside.add(favourites,0,2);

            favourites.setOnAction(new EventHandler<ActionEvent>(){
              @Override
              public void handle(ActionEvent event){
                if(favourites.isSelected()){
                  DataController.getLoggedInUser().setAFavouriteUsers(userType);
                }else if(!(favourites.isSelected())){
                  DataController.getLoggedInUser().RemoveAFavouriteUsers(userType);
                }

              }
            });
            if(filter){
              if(favourites.isSelected()){
                gridPane.add(gridPaneInside,x,y);
              }
            }if(!filter){
              gridPane.add(gridPaneInside,x,y);
            }

            x++;
          }else{

        }}catch(ClassCastException e){
          System.out.println(e);
          break;
        }



      }
  //    auctionsList = Filter.currentUserAuctions(DataController.getAuctionTree(),
    //          DataController.getLoggedInUser());
    }



  }
