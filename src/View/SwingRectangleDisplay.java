package View;

import java.awt.Point;
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
        this.addMouseListener(mouseListener());
        this.addMouseMotionListener(mouseMotionListener());
    }
    
    @Override
    public void display(Point rectangle ,Point position) {
        this.rectangle = rectangle;
        this.position = position;
        this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
        this.getGraphics().drawRect(this.position.x, this.position.y, this.rectangle.x, this.rectangle.y);
        this.getGraphics().fillRect(this.position.x, this.position.y, this.rectangle.x, this.rectangle.y);
    }

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
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
                if(x < position.x || x > position.x + rectangle.x || y < position.y || y > position.y + rectangle.y){
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
