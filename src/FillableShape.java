import java.awt.*;

/**
 * An abstract class that models LineShapes which can have a fill colour.
 * @author Christopher Evans
 * @version 1.0
 */
public abstract class FillableShape extends LineShape {
    private boolean isFilled; // Determines whether the shape has a fill colour.
    private Color fillColour; // The fill colour (if the shape has one).
}
