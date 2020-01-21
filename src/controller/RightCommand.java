package controller;

import model.Rectangle;
import swing.SwingRectangleDialog;
import swing.SwingRectangleDisplay;
import java.awt.Point;
import javax.swing.JOptionPane;
import presenter.RectanglePresenter;

public class RightCommand implements Command{
    
    private final SwingRectangleDisplay swingRectangleDisplay;
    private final SwingRectangleDialog swingRectangleDialog;
    private final Rectangle rectangle;
    
    public RightCommand(RectanglePresenter rectanglePresenter){  
        this.swingRectangleDisplay = rectanglePresenter.getSwingRectangleDisplay();
        this.swingRectangleDialog = rectanglePresenter.getSwingRectangleDialog();
        this.rectangle = rectanglePresenter.getRectangle();
    }

        @Override
    public void execute() {
        if(swingRectangleDialog.getBaseTextField() < swingRectangleDisplay.getWidth() && 
           swingRectangleDialog.getHeightTextField() < swingRectangleDisplay.getHeight()){
            rectangle.setBase(swingRectangleDialog.getBaseTextField());
            rectangle.setHeigth(swingRectangleDialog.getHeightTextField());
            moveRightPosition();
        }else{
            JOptionPane.showMessageDialog(swingRectangleDisplay, "The rectangle does not fits in the screen");
        }
    }

    private void moveRightPosition() {
        if(swingRectangleDisplay.getWidth() - (rectangle.getPosition().x + rectangle.getBase()) > 10){
            rectangle.setPosition(new Point((rectangle.getPosition().x + 10),rectangle.getPosition().y));
        }
    }
}
