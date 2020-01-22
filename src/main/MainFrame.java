package main;

import architecture.controller.Command;
import architecture.view.*;
import swing.*;
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
    
    private final Map<String, String> labels;
    private final Map<String, Command> commands;
    private final JPanel toolbar;
    
    public MainFrame(){
        this.setTitle("Figure Mover");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        this.setResizable(true);
        labels = new HashMap<>();
        commands = new HashMap<>();
        toolbar = new JPanel();
        initLabels();
        initToolbar();
        this.add(this.toolbar,BorderLayout.SOUTH);
    }
    
    public void execute(){
        this.setVisible(true);
    }
    
    public void addCommand(String name, Command command){
        commands.put(name, command);
    }
    
    public void addFigureDisplay(FigureDisplay figureDisplay){
        this.add((SwingRectangleDisplay)figureDisplay,BorderLayout.CENTER);
    }
    
    public void addFigureDialog(FigureDialog figureDialog){
        this.toolbar.add((SwingRectangleDialog)figureDialog);
    }

    private void initLabels() {
        labels.put("Left", "Move Left");
        labels.put("Right", "Move Right");
    }

    private void initToolbar() {
        this.toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.toolbar.add(button("Left"));
        this.toolbar.add(button("Right"));
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
}
