package Model;

import java.awt.Point;

public class Position {
    
    private final Point position;
    
    public Position(Point position){
        this.position = position;
    }
    
    public Point getPosition(){
        return this.position;
    }
    
    public void setPosition(Point point,Rectangle r){
        if(point.x < 0){
            changePositionLeft(point);
        }else{
            changePositionRight(point,r);
        }
    }
    
    public void setPositionScreen(Point position){
        this.position.x = position.x;
        this.position.y = position.y;
    }

    private void changePositionLeft(Point point) {
        if(this.position.x + point.x > 0){
            this.position.x += point.x;
        }
    }

    private void changePositionRight(Point point,Rectangle r) {
        if(point.y - (this.position.x + r.getBase()) > point.x){
            this.position.x += point.x;
        }
    }
}
