import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
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
    @FXML RadioButton rdioFill;
    @FXML StackPane spImageCanvas;
    @FXML public Canvas cnvCanvas;

    private double xStart;
    private double yStart;
    private double xFinish;
    private double yFinish;
    private String shapeDrawType;
    private double lineWidth;
    private Color lineColour;
    private Color fillColour;
    private ArrayList<DrawnShape> shapeList = new ArrayList<>();
    private GraphicsContext gc;



    public void initialize() {

        btnLine.setStyle("-fx-background-image: url('icons/line.png')");
        btnEllipse.setStyle("-fx-background-image: url('icons/circle.png')");
        btnRect.setStyle("-fx-background-image: url('icons/square.png')");
        btnPencil.setStyle("-fx-background-image: url('icons/pencil.png')");
        btnText.setStyle("-fx-background-image: url('icons/text.png')");
        btnBold.setStyle("-fx-background-image: url('icons/bold.png')");
        btnUnderline.setStyle("-fx-background-image: url('icons/underline.png')");

        gc = cnvCanvas.getGraphicsContext2D();
        gc.setLineWidth(lineWidth);
        gc.setStroke(lineColour);

        btnSave.setOnAction(event -> {
            saveImage();
        });


        cnvCanvas.setOnMousePressed(event -> {
            setShapeStart(event.getX(), event.getY());
        });

        cnvCanvas.setOnMouseDragged(event -> {
            setShapeEnd(event.getX(), event.getY());
            drawShapes();
        });

        cnvCanvas.setOnMouseReleased(event -> {
            setShapeEnd(event.getX(), event.getY());
            drawShapes();
            addShape(event.getX(), event.getY());
        });








    }

    public void setShapeStart(double x, double y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setShapeEnd(double x, double y) {
        xFinish = x;
        yFinish = y;
    }

    private void drawShapes() {
        gc.clearRect(0, 0, cnvCanvas.getHeight(), cnvCanvas.getHeight());
        for (DrawnShape s : shapeList) {
            s.draw(gc);
        }
        Line l = new Line(xStart, yStart, xFinish, yFinish, lineColour,
                lineWidth);
        l.draw(gc);

    }

    private void addShape(double xFinish, double yFinish) {
        Line l = new Line(xStart, yStart, xFinish, yFinish, lineColour,
                lineWidth);
        shapeList.add(l);
//        if (shapeDrawType == "Line") {
//            Line l = new Line(xStart, yStart, xFinish, yFinish);
//            shapeList.add(l);
//        } else if (shapeDrawType == "Rectangle") {
//            Rectangle r = new Rectangle(xStart, yStart, xFinish, yFinish, lineColour, stroke, isFilled, fillColour);
//            shapeList.add(r);
//        } else if (shapeDrawType == "Ellipse") {
//            setStroke();
//            Ellipse e = new Ellipse(xStart, yStart, xFinish, yFinish, lineColour, stroke, isFilled, fillColour);
//            shapeList.add(e);
//        }  else if (shapeDrawType == "Text") {
//            Text t = new Text(xFinish, yFinish, textDisplayMessage, font);
//            shapeList.add(t);
//        }
    }

    public void saveImage() {
        try {
            WritableImage wi = new WritableImage((int) cnvCanvas.getWidth(), (int)
                    cnvCanvas.getHeight());
            cnvCanvas.snapshot(null, wi);
            RenderedImage ri = SwingFXUtils.fromFXImage(wi, null);




            ImageIO.write(ri, "png", new File("src" + File.separator +
                    "profile-pics" + File.separator + DataController
                    .getLoggedInUser().getUsername() + ".png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
