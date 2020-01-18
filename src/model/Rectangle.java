package model;

import presenter.Observer;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Rectangle implements Figure{
    
    private double base;
    private double heigth;
    private Point position;
    private final List<Observer> observers;
    
    public Rectangle(double base, double heigth,Point position) {
        this.base = base;
        this.heigth = heigth;
        this.position = position;
        this.observers = new ArrayList<>();
    }
    
    public double getBase() {
        return this.base;
    }

    public double getHeigth() {
        return this.heigth;
    }
    
    public Point getPosition() {
        return this.position;
    }
    
    public void setBase(double base) {
        this.base = base;
        this.notifyObservers();
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
        this.notifyObservers();
    }
    
    public void setPosition(Point position) {
        this.position = position;
        this.notifyObservers();
    }
    
    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
