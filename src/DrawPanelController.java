import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DrawPanelController {


    @FXML ToolBar toolbarDraw;
    @FXML Button btnSave;
    @FXML ToggleButton btnLine;
    @FXML ToggleButton btnEllipse;
    @FXML ToggleButton btnRect;
    @FXML ToggleButton btnPencil;
    @FXML ToggleButton btnText;
    @FXML ToggleButton btnBold;
    @FXML ToggleButton btnUnderline;
    @FXML ToggleButton btnEraser;
    @FXML ColorPicker colLine;
    @FXML ColorPicker colFill;
    @FXML RadioButton rdioFill;
    @FXML StackPane spImageCanvas;
    @FXML Canvas cnvCanvas;
    @FXML ChoiceBox choiceLineWidth;

    private double xStart;
    private double yStart;
    private double xFinish;
    private double yFinish;
    private String shapeDrawType = "Line";
    private double lineWidth = 1.0;
    private Color lineColour = Color.BLACK;
    private Color fillColour = Color.BLACK;
    private boolean isFilled = false;
    private boolean isTextBold = false;
    private boolean isTextUnderlined = false;
    private ArrayList<DrawnShape> shapeList = new ArrayList<>();
    private GraphicsContext gc;



    public void initialize() {

        ToggleGroup drawToolToggleGroup = new ToggleGroup();
        btnLine.setToggleGroup(drawToolToggleGroup);
        btnEllipse.setToggleGroup(drawToolToggleGroup);
        btnRect.setToggleGroup(drawToolToggleGroup);
        btnPencil.setToggleGroup(drawToolToggleGroup);
        btnEraser.setToggleGroup(drawToolToggleGroup);
        btnText.setToggleGroup(drawToolToggleGroup);

        btnLine.setStyle("-fx-background-image: url('icons/line.png')");
        btnEllipse.setStyle("-fx-background-image: url('icons/circle.png')");
        btnRect.setStyle("-fx-background-image: url('icons/square.png')");
        btnPencil.setStyle("-fx-background-image: url('icons/pencil.png')");
        btnText.setStyle("-fx-background-image: url('icons/text.png')");
        btnEraser.setStyle("-fx-background-image: url('icons/eraser.png')");

        btnLine.setSelected(true);

        choiceLineWidth.getItems().add(1);
        choiceLineWidth.getItems().add(2);
        choiceLineWidth.getItems().add(3);
        choiceLineWidth.getItems().add(4);
        choiceLineWidth.getItems().add(5);
        choiceLineWidth.getItems().add(6);

        gc = cnvCanvas.getGraphicsContext2D();
        gc.setLineWidth(lineWidth);
        gc.setStroke(lineColour);

        btnSave.setOnAction(event -> {
            saveImage();
        });

        btnLine.setOnAction(event -> {
            shapeDrawType = "Line";
        });

        btnRect.setOnAction(event -> {
            shapeDrawType = "Rectangle";
        });

        btnEllipse.setOnAction(event -> {
            shapeDrawType = "Ellipse";
        });

        btnPencil.setOnAction(event -> {
            shapeDrawType = "Pencil";
        });

        choiceLineWidth.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                // can't cast directly from Integer to double
                int intLineWidth = (int) choiceLineWidth.getValue();
                lineWidth = (double) intLineWidth;
            }
        });

        rdioFill.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
                                Boolean oldValue, Boolean newValue) {
                setFillState();
            }
        });

        colLine.setOnAction(event -> {
            lineColour = colLine.getValue();
        });

        colFill.setOnAction(event -> {
            fillColour = colFill.getValue();
        });

        btnText.setOnAction(event -> {
            shapeDrawType = "Text";
        });


        btnBold.setOnAction(event -> {
            setBoldState();
        });

        btnUnderline.setOnAction(event -> {
            setUnderlineState();
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

        if (shapeDrawType == "Line") {
            Line l = new Line(xStart, yStart, xFinish, yFinish, lineColour,
                lineWidth);
            l.draw(gc);
        } else if (shapeDrawType == "Rectangle") {
            Rectangle r = new Rectangle(xStart, yStart, xFinish, yFinish,
                    lineWidth, lineColour, isFilled, fillColour);
            r.draw(gc);
        } else if (shapeDrawType == "Ellipse") {
            Ellipse e = new Ellipse(xStart, yStart, xFinish, yFinish,
                    lineWidth, lineColour, isFilled, fillColour);
            e.draw(gc);
        } else if (shapeDrawType == "Pencil") {
            Ellipse e = new Ellipse(xFinish - lineWidth, yFinish - lineWidth,
                    xFinish, yFinish, lineWidth, lineColour, true, lineColour);
            e.draw(gc);
            shapeList.add(e);
        }

    }

    private void addShape(double xFinish, double yFinish) {
        if (shapeDrawType == "Line") {
            Line l = new Line(xStart, yStart, xFinish, yFinish, lineColour,
                lineWidth);
            shapeList.add(l);
        } else if (shapeDrawType == "Rectangle") {
            Rectangle r = new Rectangle(xStart, yStart, xFinish, yFinish,
                    lineWidth, lineColour, isFilled, fillColour);
            shapeList.add(r);
        } else if (shapeDrawType == "Ellipse") {
            Ellipse e = new Ellipse(xStart, yStart, xFinish, yFinish,
                    lineWidth, lineColour, isFilled, fillColour);
            shapeList.add(e);
        }

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

    private void saveImage() {
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

    private void setFillState() {
        if (rdioFill.isSelected()) {
            isFilled = true;
        } else {
            isFilled = false;
        }
    }

    private void handleLineColourPicker() {
        lineColour = colLine.getValue();
    }

    private void handleFillColourPicker() {
        fillColour = colFill.getValue();
    }

    private void setBoldState() {
        if (btnBold.isSelected()) {
            isTextBold = true;
        } else {
            isTextBold = false;
        }
    }

    private void setUnderlineState() {
        if (btnUnderline.isSelected()) {
            isTextUnderlined = true;
        } else {
            isTextUnderlined = false;
        }
    }

    private void toggleDrawToolGroup(ToggleButton selectedButton) {

    }





}
