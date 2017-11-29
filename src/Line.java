import java.awt.*;
import java.awt.geom.Line2D;

public class Line extends LineShape {
//    private String name = "Line";
    private BasicStroke stroke = new BasicStroke();
    private int xStart = 0;
    private int yStart = 0;
    private int xFinish = 0;
    private int yFinish = 0;
    private Color lineColour = Color.BLACK;

    public Line(int xStart, int yStart, int xFinish, int yFinish, Color lineColour, BasicStroke
                stroke){
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.lineColour = lineColour;
        this.stroke = stroke;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(stroke);
        g.drawLine(xStart, yStart, xFinish, yFinish);
    }

//    public String getName() {
//        return this.name;
//    }


}
