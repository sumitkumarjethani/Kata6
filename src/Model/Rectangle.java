package Model;

public class Rectangle extends Figure{
    
    private double base;
    private double heigth;

    public Rectangle(double base, double heigth) {
        this.base = base;
        this.heigth = heigth;
    }
    
    public double getBase() {
        return base;
    }

    public double getHeigth() {
        return heigth;
    }
    
    public void setBase(double base) {
        this.base = base;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    @Override
    public Area createArea() {
        return new RectangleArea(this.getBase(),this.getHeigth());
    }
    
    @Override
    public String getName(){
        return "Rectangle";
    }
}
