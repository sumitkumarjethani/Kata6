package View;

import java.awt.Point;
import javax.swing.JPanel;

public class SwingRectangleDisplay extends JPanel implements FigureDisplay{
    
    @Override
    public void display(Point rectangle ,Point position) {
        this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
        this.getGraphics().drawRect(position.x, position.y, rectangle.x, rectangle.y);
        this.getGraphics().fillRect(position.x, position.y, rectangle.x, rectangle.y);
    }
}
