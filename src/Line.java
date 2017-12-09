import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


/**
 * A class which provides methods for drawing a straight line.
 * @author Christopher Evans
 * @version 1.0
 */
public class Line extends LineShape {
    // The start and finish coordinates for the drawn line.
    private double xStart = 0;
    private double yStart = 0;
    private double xFinish = 0;
    private double yFinish = 0;
    private double strokeWidth = 1.0;
    private Color lineColour = Color.BLACK; // The colour of the line

    /**
     * Constructs a line object containing the various properties required
     * for drawing it/
     * @param xStart The x position of the line's starting coordinate.
     * @param yStart The y position of the line's starting coordinate.
     * @param xFinish The x position of the line's finishing coordinate.
     * @param yFinish The y position of the line's finishing coordinate.
     *
     *
     */
    public Line(double xStart, double yStart, double xFinish, double yFinish,
                Color lineColour, double strokeWidth){
        // Assign the parameter values to attributes.
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.lineColour = lineColour;
        this.strokeWidth = strokeWidth;
    }

    /**
     * Draws the line using the given Graphics object.
     * @param g The Graphics object containing the drawing properties.
     */
    public void draw(GraphicsContext g) {
//        Graphics2D g2 = (Graphics2D)g; // Obtain a Graphics2D object via casting
//        g2.setStroke(stroke); // Set the Graphics object's stroke property
//        g.setLineWidth(strokeWidth);

        g.setStroke(lineColour);
        g.strokeLine(xStart, yStart, xFinish, yFinish); // Draw the line

    }
}
