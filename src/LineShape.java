import java.awt.*;

/**
 * An abstract class which models shapes consisting of lines.
 * @author Christopher Evans
 * @version 1.0
 */
public abstract class LineShape extends DrawnShape {
    // The position of the starting and finishing drawing coordinates.
    private int xStart;
    private int yStart;
    private int xFinish;
    private int yFinish;

    private BasicStroke stroke; // Stroke object containing drawing properties
    private Color lineColour = Color.BLACK; // The default line colour
}
