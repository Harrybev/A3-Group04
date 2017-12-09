import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Provides specific methods for drawing an Ellipse.
 * @author Christopher Evans
 * @version 1.0
 */
public class Ellipse extends FillableShape {
    private int xStart = 0; // The start x coordinate of the boundary-rectangle
    private int yStart = 0; // The start y coordinate of the boundary-rectangle
    private int xFinish = 0; // The end x coordinate of the boundary-rectangle
    private int yFinish = 0; // The end y coordinate of the boundary-rectangle
    private Color lineColour = Color.BLACK; // Line colour
    private Color fillColour = Color.BLACK; // Fill colour
    private boolean isFilled = true; // Determines whether the ellipse is filled
    BasicStroke stroke; // Holds the stroke properties used to draw the ellipse

    /**
     * Constructs an ellipse which can be drawn using the given parameter
     * values.
     * @param xStart The starting x coordinate of the boundary-rectangle.
     * @param yStart The starting y coordinate of the boundary-rectangle.
     * @param xFinish The ending x coordinate of the boundary-rectangle.
     * @param yFinish The ending y coordinate of the boundary-rectangle.
     * @param lineColour The colour used to draw the outline of the ellipse.
     * @param stroke The stroke object containing various drawing related
     *               properties.
     * @param isFilled Determines whether the ellipse will have a fill colour.
     * @param fillColour The fill colour if the ellipse has one.
     */
    public Ellipse(int xStart, int yStart, int xFinish, int yFinish, Color
            lineColour, BasicStroke stroke, boolean isFilled, Color fillColour){
        // Assign the parameter values to the ellipse' attributes
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.lineColour = lineColour;
        this.stroke = stroke;
        this.isFilled = isFilled;
        this.fillColour = fillColour;
    }

    /**
     * Method which draws the ellipse using the given graphics object.
     * @param g The Graphics object containing the drawing properties.
     */
    public void draw(GraphicsContext g) {
//        Graphics2D g2 = (Graphics2D)g;  // Obtain a Graphics2D object bu casting
//
//        // Calculate boundary-rectangle from start and finish coordinates
//        int pointX = Math.min(xStart,xFinish);
//        int pointY = Math.min(yStart,yFinish);
//        int width=Math.abs(xStart-xFinish);
//        int height=Math.abs(yStart-yFinish);
//
//        g2.setStroke(stroke);   // Set the graphics object's stroke
//
//        // Draw the ellipse
//        g2.draw(new Ellipse2D.Double(pointX, pointY, width, height));
    }
}
