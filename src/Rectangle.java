import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

/**
 * A class which provides methods for drawing a rectangle.
 * @author Christopher Evans
 * @version 1.0
 */
public class Rectangle extends FillableShape {
    // x and y positions for the start and end coordinates of the rectangle
    private int xStart = 0;
    private int yStart = 0;
    private int xFinish = 0;
    private int yFinish = 0;

    private Color lineColour = Color.BLACK; // Line colour
    private Color fillColour = Color.BLACK; // Fill colour if applicable
    private boolean isFilled = true; // Determines whether to display a fill
    BasicStroke stroke; // Stroke object for holding drawing properties

    /**
     * Construct a rectangle which can be drawn using the given values.
     * @param xStart The x position of the starting coordinate.
     * @param yStart The y position of the starting coordinate.
     * @param xFinish The x position of the finishing coordinate.
     * @param yFinish The y position of the finishing coordinate.
     * @param lineColour The colour of the line stroke.
     * @param stroke Stroke object used to hold drawing properties.
     * @param isFilled Determines whether the rectangle displays a fill colour.
     * @param fillColour The fill colours (if applicable).
     */
    public Rectangle(int xStart, int yStart, int xFinish, int yFinish, Color
            lineColour, BasicStroke stroke, boolean isFilled, Color fillColour){
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
     * Draws the rectangle using the given Graphics object.
     * @param g The Graphics object containing the drawing properties.
     */
    public void draw(GraphicsContext g) {
//        Graphics2D g2 = (Graphics2D)g; // Obtain a Graphics2D object via casting
//
//        // Calculate the rectangle area
//        int pointX = Math.min(xStart,xFinish);
//        int pointY = Math.min(yStart,yFinish);
//        int width=Math.abs(xStart-xFinish);
//        int height=Math.abs(yStart-yFinish);
//
//        g2.setStroke(stroke); // Set the stroke property of the Graphics object
//        // Check the fill property of the rectangle and draw it appropriately
//        if (isFilled) {
//            g.fillRect(pointX, pointY, width, height);
//        } else {
//            g.drawRect(pointX, pointY, width, height);
//        }
    }
}
