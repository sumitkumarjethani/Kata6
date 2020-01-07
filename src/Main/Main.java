package Main;

import Controller.LeftCommand;
import Controller.RightCommand;
import Model.Rectangle;
import View.MainFrame;
import View.SwingRectangleDialog;
import View.SwingRectangleDisplay;

public class Main {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(50,10);
        MainFrame mainFrame = new MainFrame();
        SwingRectangleDisplay swingRectangleDisplay = new SwingRectangleDisplay();
        SwingRectangleDialog swingRectangleDialog = new SwingRectangleDialog();
        mainFrame.addSwingRectangleDisplay(swingRectangleDisplay);
        mainFrame.addRectangleDialog(swingRectangleDialog);
        mainFrame.addCommand("Left", new LeftCommand(swingRectangleDisplay,swingRectangleDialog,r));
        mainFrame.addCommand("Right", new RightCommand(swingRectangleDisplay,swingRectangleDialog,r));
        mainFrame.execute();
    }
    
}
