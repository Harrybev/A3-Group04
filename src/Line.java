import java.awt.*;

/**
 * A class which provides methods for drawing a straight line.
 * @author Christopher Evans
 * @version 1.0
 */
public class Line extends LineShape {
    // The start and finish coordinates for the drawn line.
    private int xStart = 0;
    private int yStart = 0;
    private int xFinish = 0;
    private int yFinish = 0;

    private BasicStroke stroke; // Holds the drawing properties of the line
    private Color lineColour = Color.BLACK; // The colour of the line

    /**
     * Constructs a line object containing the various properties required
     * for drawing it/
     * @param xStart The x position of the line's starting coordinate.
     * @param yStart The y position of the line's starting coordinate.
     * @param xFinish The x position of the line's finishing coordinate.
     * @param yFinish The y position of the line's finishing coordinate.
     * @param lineColour The colour which the line will be drawn with.
     * @param stroke The stroke object used to draw the line.
     */
    public Line(int xStart, int yStart, int xFinish, int yFinish, Color lineColour, BasicStroke
                stroke){
        // Assign the parameter values to attributes.
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.lineColour = lineColour;
        this.stroke = stroke;
    }

    /**
     * Draws the line using the given Graphics object.
     * @param g The Graphics object containing the drawing properties.
     */
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g; // Obtain a Graphics2D object via casting
        g2.setStroke(stroke); // Set the Graphics object's stroke property
        g.drawLine(xStart, yStart, xFinish, yFinish); // Draw the line
    }
}
