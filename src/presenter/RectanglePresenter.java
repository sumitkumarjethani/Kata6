package presenter;

import model.Rectangle;
import view.FigureDisplay;
import view.SwingRectangleDisplay;
import java.awt.Point;
import view.SwingRectangleDialog;

public class RectanglePresenter implements Observer{

    private final SwingRectangleDisplay swingRectangleDisplay;
    private final SwingRectangleDialog swingRectangleDialog;
    private final Rectangle rectangle;
    
    public RectanglePresenter(SwingRectangleDisplay swingRectangleDisplay , SwingRectangleDialog swingRectangleDialog , Rectangle rectangle){
        this.swingRectangleDisplay = swingRectangleDisplay;
        this.swingRectangleDialog = swingRectangleDialog;
        this.rectangle = rectangle;
        this.rectangle.addObserver(this);
        this.swingRectangleDisplay.addListener(new FigureDisplay.Listener() {
            @Override
            public void newPosition(Point point) {
                rectangle.setPosition(point);
            }
        });             
    }
    
    @Override
    public void update() {
        this.swingRectangleDisplay.display(new Point((int)this.rectangle.getBase(),(int)this.rectangle.getHeigth()), 
                                           this.rectangle.getPosition());
    }
    
    public SwingRectangleDisplay getSwingRectangleDisplay() {
        return swingRectangleDisplay;
    }

    public SwingRectangleDialog getSwingRectangleDialog() {
        return swingRectangleDialog;
    }
    
    public Rectangle getRectangle() {
        return rectangle;
    }
}
