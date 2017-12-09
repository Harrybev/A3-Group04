import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

public class DrawPanelController {


    @FXML ToolBar toolbarDraw;
    @FXML Button btnSave;
    @FXML Button btnLine;
    @FXML Button btnEllipse;
    @FXML Button btnRect;
    @FXML Button btnPencil;
    @FXML Button btnText;
    @FXML Button btnBold;
    @FXML Button btnUnderline;
    @FXML TextField txtStrokeWidth;
    @FXML TextField txtFontSize;
    @FXML ColorPicker colLine;
    @FXML ColorPicker colFill;
    @FXML ImageView ivCanvas;
    @FXML StackPane spImageCanvas;

    private Stage previousStage;
//    private Color lineColour = Color.BLACK;
//    private float strokeWidth = 10.0f;
//    private BasicStroke stroke = new BasicStroke(strokeWidth);
//    private boolean dashedStroke = false;
//    private float[] dashedValue = {2.0f};
//    private Color fillColour = Color.RED;
//    boolean isFilled = true;
//    private String shapeDrawType = "Rectangle";
//    private String textDisplayMessage = "test";
//    private Font font = new Font("Serif", Font.PLAIN, 18);
//    private ArrayList<DrawnShape> shapeList = new ArrayList<>();
//    private int xStart = 0;
//    private int yStart = 0;
//    private int xFinish = 0;
//    private int yFinish = 0;




    public void initialize() {

        btnLine.setStyle("-fx-background-image: url('icons/line.png')");
        btnEllipse.setStyle("-fx-background-image: url('icons/circle.png')");
        btnRect.setStyle("-fx-background-image: url('icons/square.png')");
        btnPencil.setStyle("-fx-background-image: url('icons/pencil.png')");
        btnText.setStyle("-fx-background-image: url('icons/text.png')");
        btnBold.setStyle("-fx-background-image: url('icons/bold.png')");
        btnUnderline.setStyle("-fx-background-image: url('icons/underline.png')");
        spImageCanvas.setStyle("-fx-border-width: 2; -fx-border-color: black");


    }

    public void setPreviousStage(Stage previousStage) {
        this.previousStage = previousStage;
    }
}
