import java.awt.*;

public abstract class LineShape extends DrawnShape {
    private int xStart;
    private int yStart;
    private BasicStroke stroke = new BasicStroke();
    private Color lineColour = Color.BLACK;
}
