package model;

import observer.Observer;

public interface Figure {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
