import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class Text extends DrawnShape {

//    private String name = "Text";
    private String displayString = "test";
    private Font font = new Font("Serif", Font.PLAIN, 12);
    private int xFinish = 0;
    private int yFinish = 0;

    public Text(int xFinish, int yFinish, String displayString, Font font){
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.displayString = displayString;
        this.font = font;
    }

    public void draw(GraphicsContext g){
//        g.drawString(displayString, xFinish, yFinish);
    }
//    public String getName(){
//       return this.name;
//    }

}
