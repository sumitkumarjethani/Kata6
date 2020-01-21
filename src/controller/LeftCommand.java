package controller;

import model.Rectangle;
import swing.SwingRectangleDialog;
import swing.SwingRectangleDisplay;
import java.awt.Point;
import javax.swing.JOptionPane;
import presenter.RectanglePresenter;

public class LeftCommand implements Command{
    
    private final SwingRectangleDisplay swingRectangleDisplay;
    private final SwingRectangleDialog swingRectangleDialog;
    private final Rectangle rectangle;
    
    public LeftCommand(RectanglePresenter rectanglePresenter){
        this.swingRectangleDisplay = rectanglePresenter.getSwingRectangleDisplay();
        this.swingRectangleDialog = rectanglePresenter.getSwingRectangleDialog();
        this.rectangle = rectanglePresenter.getRectangle();
    }
    
    @Override
    public void execute() {
        if(this.swingRectangleDialog.getBaseTextField() < this.swingRectangleDisplay.getWidth() && 
                this.swingRectangleDialog.getHeightTextField() < this.swingRectangleDisplay.getHeight()){
            rectangle.setBase(this.swingRectangleDialog.getBaseTextField());
            rectangle.setHeigth(this.swingRectangleDialog.getHeightTextField());
            moveLeftPosition();
        }else{
            JOptionPane.showMessageDialog(this.swingRectangleDisplay, "The rectangle does not fits in the screen");
        }
    }

    private void moveLeftPosition() {
        if(rectangle.getPosition().x - 10 > 0) rectangle.setPosition(new Point(rectangle.getPosition().x - 10, 
                                                                               rectangle.getPosition().y));
    }
    
}
