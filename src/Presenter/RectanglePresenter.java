package Presenter;

import Model.Rectangle;
import View.SwingRectangleDisplay;
import java.awt.Point;

public class RectanglePresenter implements Observer{

    private final SwingRectangleDisplay swingRectangleDisplay;
    private final Rectangle rectangle;
    
    public RectanglePresenter(SwingRectangleDisplay swingRectangleDisplay, Rectangle rectangle){
        this.rectangle = rectangle;
        this.swingRectangleDisplay = swingRectangleDisplay;
        this.rectangle.addObserver(this);
    }
    
    @Override
    public void update() {
        this.swingRectangleDisplay.display(new Point((int)this.rectangle.getBase(),(int)this.rectangle.getHeigth()), 
                                           this.rectangle.getPosition());
    }
}
