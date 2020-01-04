package Main;

import Controller.LeftCommand;
import Controller.RightCommand;
import Model.Rectangle;
import View.MainFrame;
import View.SwingRectangleDisplay;

public class Main {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(300,100);
        MainFrame mainFrame = new MainFrame();
        SwingRectangleDisplay swingRectangleDisplay = new SwingRectangleDisplay(r1);
        mainFrame.addSwingRectangleDisplay(swingRectangleDisplay);
        mainFrame.addCommand("Left", new LeftCommand());
        mainFrame.addCommand("Right", new RightCommand());
        mainFrame.execute();
    }
    
}
