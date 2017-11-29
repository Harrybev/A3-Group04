import java.awt.*;

public class Rectangle extends FillableShape {
    private String name = "Rectangle";
    private int xStart = 0;
    private int yStart = 0;
    private int xFinish = 0;
    private int yFinish = 0;
    private Color lineColour = Color.BLACK;
    BasicStroke stroke = new BasicStroke();
    private boolean isFilled = true;
    private Color fillColour = Color.BLACK;


    public Rectangle(int xStart, int yStart, int xFinish, int yFinish, Color lineColour, BasicStroke stroke,
                     boolean isFilled, Color fillColour){
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.lineColour = lineColour;
        this.stroke = stroke;
        this.isFilled = isFilled;
        this.fillColour = fillColour;
    }

//    @Override
//    public String getName() {
//        return name;
//    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        int pointX = Math.min(xStart,xFinish);
        int pointY = Math.min(yStart,yFinish);
        int width=Math.abs(xStart-xFinish);
        int height=Math.abs(yStart-yFinish);
        g2.setStroke(stroke);
        if (isFilled) {
            g.fillRect(pointX, pointY, width, height);
        } else {
            g.drawRect(pointX, pointY, width, height);
        }

    }
}
