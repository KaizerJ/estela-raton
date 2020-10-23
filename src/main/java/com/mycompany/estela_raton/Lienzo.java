package com.mycompany.estela_raton;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class Lienzo extends JPanel {
    
    private Color backgroundColor = Color.WHITE;
            
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(backgroundColor);
    }
    public void updateBackgroundColor(Color color){
        backgroundColor = color;
        this.repaint();
    }
}
