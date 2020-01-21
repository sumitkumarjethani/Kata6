package main;

import controller.LeftCommand;
import controller.RightCommand;
import model.Rectangle;
import presenter.RectanglePresenter;
import swing.MainFrame;
import swing.SwingRectangleDialog;
import swing.SwingRectangleDisplay;
import java.awt.Point;

public class Main {

    public static void main(String[] args) {
        //Model
        Rectangle rectangle = new Rectangle(50,10,new Point(100,100));
        //View
        MainFrame mainFrame = new MainFrame();
        SwingRectangleDisplay swingRectangleDisplay = new SwingRectangleDisplay();
        SwingRectangleDialog swingRectangleDialog = new SwingRectangleDialog();
        mainFrame.addSwingRectangleDisplay(swingRectangleDisplay);
        mainFrame.addRectangleDialog(swingRectangleDialog);
        //Presenter
        RectanglePresenter rectanglePresenter = new RectanglePresenter(swingRectangleDisplay, swingRectangleDialog, rectangle);
        //Controller
        mainFrame.addCommand("Left", new LeftCommand(rectanglePresenter));
        mainFrame.addCommand("Right", new RightCommand(rectanglePresenter));
        mainFrame.execute();
    }
    
}
