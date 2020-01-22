package swing;

import architecture.model.Point;
import architecture.view.FigureDisplay;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class SwingRectangleDisplay extends JPanel implements FigureDisplay{
    
    private final List<FigureDisplay.Listener> listeners = new ArrayList<>();
    private boolean grabbed = false;
    private Point rectangle;
    private Point position;
    
    public SwingRectangleDisplay(){
        this.setSize(400,300);
        this.addMouseListener(mouseListener());
        this.addMouseMotionListener(mouseMotionListener());
    }
    
    @Override
    public void display(Point[] points ,Point position) {
        this.rectangle = points[0];
        this.position = position;
        this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
        this.getGraphics().drawRect((int)this.position.getX(), (int)this.position.getY(), (int)this.rectangle.getX(), (int)this.rectangle.getY());
        this.getGraphics().fillRect((int)this.position.getX(), (int)this.position.getY(), (int)this.rectangle.getX(), (int)this.rectangle.getY());
    }
    
    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    
    @Override
    public Point getDisplaySize(){
        return new Point(this.getWidth(),this.getHeight());
    }

    private MouseListener mouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                if(isTouchingRectangle(me.getX(),me.getY())) grabbed = true;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                grabbed = false;
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }

            private boolean isTouchingRectangle(int x, int y) {
                if(isInsideRectangle(x, y)) return true;
                return false;
            }

            private boolean isInsideRectangle(int x, int y) {
                if(position == null || rectangle == null) return false;
                if(x < position.getX() || x > position.getX() + rectangle.getX() || y < position.getY() || y > position.getY() + rectangle.getY()){
                    return false;
                }else{
                    return true;
                }
            }
        };
    }

    private MouseMotionListener mouseMotionListener() {
        return new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
                if(!grabbed) return;
                for (Listener listener : listeners) {
                    listener.newPosition(new Point(me.getX(),me.getY()));
                }
            }

            @Override
            public void mouseMoved(MouseEvent me) {
            }
        };
    }

}
