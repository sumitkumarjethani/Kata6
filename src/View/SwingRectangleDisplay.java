package View;

import Model.Figure;
import Model.Rectangle;
import javax.swing.JPanel;

public class SwingRectangleDisplay extends JPanel implements FigureDisplay{
    
    private int x;
    private final int y;
    
    public SwingRectangleDisplay(){
        this.x = 100;
        this.y = 100;
    }
    
    @Override
    public void display(Figure figure , int x) {
        Rectangle rectangle = (Rectangle) figure;
        if(x < 0){
            moveLeft(rectangle, x);
        }else{
            moveRight(rectangle, x);
        }
    }

    private void moveLeft(Rectangle rectangle, int x) {
        if(this.x  + x > 0){
            this.x += x;
            this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
            this.getGraphics().drawRect(this.x, this.y, (int)rectangle.getBase(), (int)rectangle.getHeigth());
            this.getGraphics().fillRect(this.x, this.y, (int)rectangle.getBase(), (int)rectangle.getHeigth());
        }
    }

    private void moveRight(Rectangle rectangle, int x) {
        if(this.getWidth() - (this.x + rectangle.getBase()) > x){
            this.x += x;
            this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
            this.getGraphics().drawRect(this.x, this.y, (int)rectangle.getBase(), (int)rectangle.getHeigth());
            this.getGraphics().fillRect(this.x, this.y, (int)rectangle.getBase(), (int)rectangle.getHeigth());
        }
    }
    
}
