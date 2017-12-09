import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

/**
 * DrawnShape is an abstract class that models shapes that are able to be drawn
 * at the highest level.
 * @author Christopher Evans
 * @version 1.0
 */
public abstract class DrawnShape {

    // The x and y coordinate marking the end of the drawing action
    private int xFinish;
    private int yFinish;

    /**
     * Draws the shape using the given graphics object's properties (e.g. stroke
     * colour and width)
     * @param g The Graphics object containing the drawing properties.
     */
    public abstract void draw(GraphicsContext g);
}
