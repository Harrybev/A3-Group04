import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private Color lineColour = Color.BLACK;
    private float strokeWidth = 10.0f;
    private BasicStroke stroke = new BasicStroke(strokeWidth);
    private boolean dashedStroke = false;
    private float[] dashedValue = {2.0f};
    private Color fillColour = Color.RED;
    boolean isFilled = true;
    private String shapeDrawType = "Rectangle";
    private String textDisplayMessage = "test";
    private Font font = new Font("Serif", Font.PLAIN, 18);
    private ArrayList<DrawnShape> shapeList = new ArrayList<>();
    private int xStart = 0;
    private int yStart = 0;
    private int xFinish = 0;
    private int yFinish = 0;

    public static void main(String[] args) {
        JFrame f = new JFrame("Draw Box Mouse 2");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new DrawPanel());
        f.setSize(300, 300);
        f.setVisible(true);
    }

    public DrawPanel() {
        CustomMouseListener listener = new CustomMouseListener(this);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public void setShapeStart(int x, int y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setShapeEnd(int x, int y) {
        xFinish = (x);
        yFinish = (y);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(lineColour);
        g.setFont(font);
        drawShapes(g);
   }

    private void drawShapes(Graphics g) {

        for (DrawnShape s : shapeList) {
            s.draw(g);
        }

        if (shapeDrawType == "Line") {
            setStroke();
            Line l = new Line(xStart, yStart, xFinish, yFinish, lineColour, stroke);
            l.draw(g);
        } else if (shapeDrawType == "Rectangle") {
            setStroke();
            Rectangle r = new Rectangle(xStart, yStart, xFinish, yFinish, lineColour, stroke, isFilled, fillColour);
            r.draw(g);
        } else if (shapeDrawType == "Ellipse") {
            setStroke();
            Ellipse e = new Ellipse(xStart, yStart, xFinish, yFinish, lineColour, stroke, isFilled, fillColour);
            e.draw(g);
        }  else if (shapeDrawType == "Text") {
//            g.setFont(font);
            Text t = new Text(xFinish, yFinish, textDisplayMessage, font);
            t.draw(g);
        }
    }

    public void addShape(int xFinish, int yFinish) {
        if (shapeDrawType == "Line") {
            Line l = new Line(xStart, yStart, xFinish, yFinish, lineColour, stroke);
            shapeList.add(l);
        } else if (shapeDrawType == "Rectangle") {
            Rectangle r = new Rectangle(xStart, yStart, xFinish, yFinish, lineColour, stroke, isFilled, fillColour);
            shapeList.add(r);
        } else if (shapeDrawType == "Ellipse") {
            setStroke();
            Ellipse e = new Ellipse(xStart, yStart, xFinish, yFinish, lineColour, stroke, isFilled, fillColour);
            shapeList.add(e);
        }  else if (shapeDrawType == "Text") {
            Text t = new Text(xFinish, yFinish, textDisplayMessage, font);
            shapeList.add(t);
        }
    }

//    private void setStrokeWidth(float width) {
//        this.strokeWidth = width;
//    }

    private void setStroke() {
        if (dashedStroke == true) {
            stroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashedValue, 0.0f);
        } else {
            stroke = new BasicStroke(strokeWidth);
        }
    }

    public void storeImage() {

    }

}