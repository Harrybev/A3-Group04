import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * A class which provides methods for drawing a rectangle.
 * @author Christopher Evans
 * @version 1.0
 */
public class Rectangle extends FillableShape {
    // x and y positions for the start and end coordinates of the rectangle
    private double xStart = 0;
    private double yStart = 0;
    private double xFinish = 0;
    private double yFinish = 0;

    private Color lineColour = Color.BLACK; // Line colour
    private Color fillColour = Color.BLACK; // Fill colour if applicable
    private boolean isFilled = true; // Determines whether to display a fill

    /**
     * Construct a rectangle which can be drawn using the given values.
     * @param xStart The x position of the starting coordinate.
     * @param yStart The y position of the starting coordinate.
     * @param xFinish The x position of the finishing coordinate.
     * @param yFinish The y position of the finishing coordinate.
     * @param lineColour The colour of the line stroke.
     * @param isFilled Determines whether the rectangle displays a fill colour.
     * @param fillColour The fill colours (if applicable).
     */
    public Rectangle(double xStart, double yStart, double xFinish, double
            yFinish, Color lineColour, boolean isFilled, Color fillColour){
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.lineColour = lineColour;
        this.isFilled = isFilled;
        this.fillColour = fillColour;
    }

    /**
     * Draws the rectangle using the given Graphics object.
     * @param g The Graphics object containing the drawing properties.
     */
    public void draw(GraphicsContext g) {
        g.setStroke(lineColour);
        // Calculate the rectangle area
        double pointX = Math.min(xStart,xFinish);
        double pointY = Math.min(yStart,yFinish);
        double width = Math.abs(xStart-xFinish);
        double height = Math.abs(yStart-yFinish);

        // Check the fill property of the rectangle and draw it appropriately
        if (isFilled) {
            g.setFill(fillColour);
            g.fillRect(pointX, pointY, width, height);
            g.strokeRect(pointX, pointY, width, height);
        } else {
            g.strokeRect(pointX, pointY, width, height);
        }
    }
}
