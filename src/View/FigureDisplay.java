package View;

import java.awt.Point;


public interface FigureDisplay {
    
    public void display(Point rectangle, Point position);
    public void addListener(FigureDisplay.Listener listener);
    
    public interface Listener{
        public void newPosition(Point point);
    }
}
