package View;

import Model.Rectangle;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SwingRectangleDisplay extends JPanel implements FigureDisplay{
    
    private final Rectangle rectangle;
    
    public SwingRectangleDisplay(Rectangle rectangle){
        this.rectangle = rectangle;
    }
    
    @Override
    public void Display() {
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        g.drawRect(10, 10, (int)this.rectangle.getBase(), (int)this.rectangle.getHeigth());
        g.fillRect(10, 10, (int)this.rectangle.getBase(), (int)this.rectangle.getHeigth());
    }
    
}
