package architecture.view;

import architecture.model.Point;

public interface FigureDisplay {
    
    public void display(Point[] points, Point position);
    public void addListener(FigureDisplay.Listener listener);
    public Point getDisplaySize();
    
    public interface Listener{
        public void newPosition(Point point);
    }
}
