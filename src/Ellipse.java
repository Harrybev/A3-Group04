import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * Provides specific methods for drawing an Ellipse.
 * @author Christopher Evans
 * @version 1.0
 */
public class Ellipse extends FillableShape {
    private double xStart = 0; // The start x coordinate of the
    // boundary-rectangle
    private double yStart = 0; // The start y coordinate of the
    // boundary-rectangle
    private double xFinish = 0; // The end x coordinate of the
    // boundary-rectangle
    private double yFinish = 0; // The end y coordinate of the
    // boundary-rectangle
    private double strokeWidth = 0.0;
    private Color lineColour = Color.BLACK; // Line colour
    private Color fillColour = Color.BLACK; // Fill colour
    private boolean isFilled = true; // Determines whether the ellipse is filled

    /**
     * Constructs an ellipse which can be drawn using the given parameter
     * values.
     * @param xStart The starting x coordinate of the boundary-rectangle.
     * @param yStart The starting y coordinate of the boundary-rectangle.
     * @param xFinish The ending x coordinate of the boundary-rectangle.
     * @param yFinish The ending y coordinate of the boundary-rectangle.
     * @param lineColour The colour used to draw the outline of the ellipse.
     * @param isFilled Determines whether the ellipse will have a fill colour.
     * @param fillColour The fill colour if the ellipse has one.
     */
    public Ellipse(double xStart, double yStart, double xFinish, double
            yFinish, double strokeWidth, Color lineColour, boolean isFilled,
                   Color fillColour){
        // Assign the parameter values to the ellipse' attributes
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.strokeWidth = strokeWidth;
        this.lineColour = lineColour;
        this.isFilled = isFilled;
        this.fillColour = fillColour;
    }

    /**
     * Method which draws the ellipse using the given graphics object.
     * @param g The Graphics object containing the drawing properties.
     */
    public void draw(GraphicsContext g) {
        g.setStroke(lineColour);
        g.setLineWidth(strokeWidth);
        // Calculate the rectangle area
        double pointX = Math.min(xStart,xFinish);
        double pointY = Math.min(yStart,yFinish);
        double width = Math.abs(xStart-xFinish);
        double height = Math.abs(yStart-yFinish);

        // Check the fill property of the rectangle and draw it appropriately
        if (isFilled) {
            g.setFill(fillColour);
            g.fillOval(pointX, pointY, width, height);
            g.strokeOval(pointX, pointY, width, height);
        } else {
            g.strokeOval(pointX, pointY, width, height);
        }
    }
}
