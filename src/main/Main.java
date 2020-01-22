package main;

import architecture.controller.LeftCommand;
import architecture.controller.RightCommand;
import architecture.model.Point;
import architecture.model.Rectangle;
import architecture.presenter.RectanglePresenter;
import architecture.view.*;
import swing.*;

public class Main {

    public static void main(String[] args) {
        //Model
        Rectangle rectangle = new Rectangle(50,10,new Point(100,100));
        //View
        FigureDialog figureDialog = new SwingRectangleDialog();
        FigureDisplay figureDisplay = new SwingRectangleDisplay();
        //MainFrame
        MainFrame mainFrame = new MainFrame();
        mainFrame.addFigureDialog(figureDialog);
        mainFrame.addFigureDisplay(figureDisplay);
        //Presenter
        RectanglePresenter rectanglePresenter = new RectanglePresenter(figureDisplay, figureDialog, rectangle);
        //Controller
        mainFrame.addCommand("Left", new LeftCommand(rectanglePresenter));
        mainFrame.addCommand("Right", new RightCommand(rectanglePresenter));
        mainFrame.execute();
    }
    
}
