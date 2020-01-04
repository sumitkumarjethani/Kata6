package View;

import Controller.Command;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    private final Map<String,String> labels;
    private final Map<String,Command> commands;
    
    public MainFrame(){
        this.setTitle("Figure Mover");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setResizable(false);
        labels = new HashMap<>();
        commands = new HashMap<>();
        initLabels();
        this.add(toolbar(),BorderLayout.SOUTH);
    }
    
    public void execute(){
        this.setVisible(true);
    }

    private void initLabels() {
        labels.put("Left", "Move Left");
        labels.put("Right", "Move Right");
    }

    private JPanel toolbar() {
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        toolbar.add(button("Left"));
        toolbar.add(button("Right"));
        return toolbar;
    }

    private JButton button(String id) {
        JButton button = new JButton(labels.get(id));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(id).execute();
            }
        });
        return button;
    }
    
    public void addCommand(String name, Command command){
        commands.put(name, command);
    }
    
    public void addSwingRectangleDisplay(SwingRectangleDisplay swingRectangleDisplay){
        this.add(swingRectangleDisplay, BorderLayout.CENTER);
    }
}
