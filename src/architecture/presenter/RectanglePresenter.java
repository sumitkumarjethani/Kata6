package architecture.presenter;

import architecture.model.Point;
import architecture.model.Rectangle;
import architecture.observer.Observer;
import architecture.view.*;
import java.awt.Component;
import javax.swing.JOptionPane;

public class RectanglePresenter implements Observer{
    
    private final FigureDisplay figureDisplay;
    private final FigureDialog figureDialog;
    private final Rectangle rectangle;
    
    public RectanglePresenter(FigureDisplay figureDisplay , FigureDialog figureDialog , Rectangle rectangle){
        this.figureDisplay = figureDisplay;
        this.figureDialog = figureDialog;
        this.rectangle = rectangle;
        this.rectangle.addObserver(this);
        this.figureDisplay.addListener(new FigureDisplay.Listener() {
            @Override
            public void newPosition(Point point) {
                rectangle.setPosition(point);
            }
        });
    }
    
    @Override
    public void update() {
        Point[] points = {new Point(this.rectangle.getBase(),this.rectangle.getHeigth())};
        this.figureDisplay.display(points,this.rectangle.getPosition());
    }
    
    public FigureDisplay getFigureDisplay() {
        return figureDisplay;
    }

    public FigureDialog getFigureDialog() {
        return figureDialog;
    }
    
    public Rectangle getRectangle() {
        return rectangle;
    }
    
    public Point changePositionLeft(){
        Point[] points = this.figureDialog.getPoints();
        Point displaySize = this.figureDisplay.getDisplaySize();
        if(points[0].getX() < displaySize.getX() && points[0].getY() < displaySize.getY()){
            if(this.rectangle.getPosition().getX() - 10 > 0){
                Point point = new Point(rectangle.getPosition().getX()-10,rectangle.getPosition().getY());
                return point;
            }
        }else{
            JOptionPane.showMessageDialog((Component) this.figureDisplay, "The rectangle does not fits in the screen");
        }
        return this.rectangle.getPosition();
    }
    
    public Point changePositionRight(){
        Point[] points = this.figureDialog.getPoints();
        Point displaySize = this.figureDisplay.getDisplaySize();
        if(points[0].getX() < displaySize.getX() && points[0].getY() < displaySize.getY()){
            if(displaySize.getX() - (rectangle.getPosition().getX() + rectangle.getBase()) > 10){
                Point point = new Point((rectangle.getPosition().getX() + 10),rectangle.getPosition().getY());
                return point;
            }
        }else{
            JOptionPane.showMessageDialog((Component) this.figureDisplay, "The rectangle does not fits in the screen");
        }
        return this.rectangle.getPosition();
    }
    
}
