package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AppCanvas extends JPanel {
    
    public static final int WIDTH = 400;
    public static final int HEIGHT = 100;

    public AppCanvas() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        
    }
}
