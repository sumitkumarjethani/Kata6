package architecture.controller;

import architecture.model.Point;
import architecture.model.Rectangle;
import architecture.presenter.RectanglePresenter;
import architecture.view.FigureDialog;

public class LeftCommand implements Command{
    
    private final RectanglePresenter rectanglePresenter;
    private final FigureDialog figureDialog;
    private final Rectangle rectangle;
    
    public LeftCommand(RectanglePresenter rectanglePresenter){
        this.rectanglePresenter = rectanglePresenter;
        this.figureDialog = this.rectanglePresenter.getFigureDialog();
        this.rectangle = this.rectanglePresenter.getRectangle();
    }
    
    @Override
    public void execute() {
        Point[] points = this.figureDialog.getPoints();
        this.rectangle.setBase(points[0].getX());
        this.rectangle.setHeigth(points[0].getY());
        this.rectangle.setPosition(this.rectanglePresenter.changePositionLeft());
    }
}
