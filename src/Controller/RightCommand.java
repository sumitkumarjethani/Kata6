package Controller;

import Model.Rectangle;
import View.SwingRectangleDialog;
import View.SwingRectangleDisplay;
import javax.swing.JOptionPane;

public class RightCommand implements Command{

    private final SwingRectangleDisplay swingRectangleDisplay;
    private final SwingRectangleDialog swingRectangleDialog;
    private final Rectangle r;
    
    public RightCommand(SwingRectangleDisplay swingRectangleDisplay,SwingRectangleDialog swingRectangleDialog, Rectangle r){
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
            this.swingRectangleDisplay.display(r,+10);
        }else{
            JOptionPane.showMessageDialog(this.swingRectangleDisplay, "The rectangle does nos fit in the screen");
        }
    }
}
