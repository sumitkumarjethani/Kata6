package View;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingRectangleDialog extends JPanel{
    
    private final JTextField base;
    private final JTextField height;
    
    public SwingRectangleDialog(){
        this.setLayout(new FlowLayout());
        base = new JTextField(5);
        height = new JTextField(5);
        initToolbar();
    }
 
    
    public double getBaseTextField() {
        if(base.getText().matches("^[+]?([0-9]+(?:[\\.][0-9]*)?|\\.[0-9]+)$")){
             return Double.parseDouble(base.getText());
        }else{
            return 0.0;
        }
    }
    
    public double getHeightTextField(){
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
