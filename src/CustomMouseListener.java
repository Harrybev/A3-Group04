import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomMouseListener extends MouseAdapter{

    private DrawPanel parentPanel = null;

    public CustomMouseListener(DrawPanel parentPanel) {
        this.parentPanel = parentPanel;
    }
    public void mousePressed(MouseEvent e) {
            parentPanel.setShapeStart(e.getX(), e.getY());
        }

        public void mouseDragged(MouseEvent e) {
            parentPanel.setShapeEnd(e.getX(), e.getY());

            parentPanel.repaint();
        }

        public void mouseReleased(MouseEvent e) {
            parentPanel.setShapeEnd(e.getX(), e.getY());
            parentPanel.addShape(e.getX(), e.getY());
//            parentPanel.repaint();
        }
}
