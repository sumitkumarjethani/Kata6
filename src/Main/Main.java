package Main;

import Controller.LeftCommand;
import Controller.RightCommand;
import Model.Position;
import Model.Rectangle;
import Presenter.RectanglePresenter;
import View.MainFrame;
import View.SwingRectangleDialog;
import View.SwingRectangleDisplay;
import java.awt.Point;

public class Main {

    public static void main(String[] args) {
        //Model
        Rectangle r = new Rectangle(50,10,new Position(new Point(100,100)));
        //View
        MainFrame mainFrame = new MainFrame();
        SwingRectangleDisplay swingRectangleDisplay = new SwingRectangleDisplay();
        SwingRectangleDialog swingRectangleDialog = new SwingRectangleDialog();
        mainFrame.addSwingRectangleDisplay(swingRectangleDisplay);
        mainFrame.addRectangleDialog(swingRectangleDialog);
        //Controller
        mainFrame.addCommand("Left", new LeftCommand(swingRectangleDisplay,swingRectangleDialog,r));
        mainFrame.addCommand("Right", new RightCommand(swingRectangleDisplay,swingRectangleDialog,r));
        //Presenter
        RectanglePresenter rectanglePresenter = new RectanglePresenter(swingRectangleDisplay, r);
        mainFrame.execute();
    }
    
}
