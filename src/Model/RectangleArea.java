package Model;

public class RectangleArea implements Area{
    
    private final double base;
    private final double heigth;

    public RectangleArea(double base, double heigth) {
        this.base = base;
        this.heigth = heigth;
    }
    
    @Override
    public double getArea() {
        return this.base * this.heigth;
    }
    
}
