package Model;

public class Rectangle extends Figure{
    
    private double base;
    private double heigth;

    public Rectangle(double base, double heigth) {
        this.base = base;
        this.heigth = heigth;
    }
    
    @Override
    public String getName() {
        return "Rectangle";
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
    public double getArea() {
        return this.getBase() * this.getArea();
    }
}
