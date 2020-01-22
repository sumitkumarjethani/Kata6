package swing;

import architecture.model.Point;
import architecture.view.FigureDialog;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingRectangleDialog extends JPanel implements FigureDialog{
    
    private final JTextField base;
    private final JTextField height;
    
    public SwingRectangleDialog(){
        this.setLayout(new FlowLayout());
        base = new JTextField(5);
        height = new JTextField(5);
        initToolbar();
    }
 
    @Override
    public Point[] getPoints() {
       Point[] points = {new Point(this.getBaseTextField(),this.getHeightTextField())};
       return points;
    }
    
    private double getBaseTextField() {
        if(base.getText().matches("^[+]?([0-9]+(?:[\\.][0-9]*)?|\\.[0-9]+)$")){
             return Double.parseDouble(base.getText());
        }else{
            return 0.0;
        }
    }
    
    private double getHeightTextField(){
        if(height.getText().matches("^[+]?([0-9]+(?:[\\.][0-9]*)?|\\.[0-9]+)$")){
             return Double.parseDouble(height.getText());
        }else{
            return 0.0;
        }
    }

    private void initToolbar() {
        this.add(new JLabel("Base"));
        this.add(this.base);
        this.add(new JLabel("Height"));
        this.add(this.height);
    }
}