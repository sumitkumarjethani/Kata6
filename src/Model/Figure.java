package Model;

import Presenter.Observer;

public abstract class Figure {
    public abstract String getName();
    public abstract void addObserver(Observer o);
    public abstract void removeObserver(Observer o);
    public abstract void notifyObservers();
}
