package Controller;

import Model.Rectangle;
import View.SwingRectangleDialog;
import View.SwingRectangleDisplay;
import java.awt.Point;
import javax.swing.JOptionPane;

public class LeftCommand implements Command{
    
    private final SwingRectangleDisplay swingRectangleDisplay;
    private final SwingRectangleDialog swingRectangleDialog;
    private final Rectangle r;
    
    public LeftCommand(SwingRectangleDisplay swingRectangleDisplay,SwingRectangleDialog swingRectangleDialog,Rectangle r){
        this.swingRectangleDisplay = swingRectangleDisplay;
        this.swingRectangleDialog = swingRectangleDialog;
        this.r = r;
    }
    
    @Override
    public void execute() {
        if(this.swingRectangleDialog.getBaseTextField() < this.swingRectangleDisplay.getWidth() && 
                this.swingRectangleDialog.getHeightTextField() < this.swingRectangleDisplay.getHeight()){
            r.setBase(this.swingRectangleDialog.getBaseTextField());
            r.setHeigth(this.swingRectangleDialog.getHeightTextField());
            r.setPosition(new Point(-10,0));
        }else{
            JOptionPane.showMessageDialog(this.swingRectangleDisplay, "The rectangle does nos fit in the screen");
        }
    }
    
}
