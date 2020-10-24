package com.mycompany.estela_raton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;


public class Lienzo extends JPanel {
    
    private static int TRAIL_LENGTH = 5;
    
    private Color backgroundColor = Color.WHITE;
    private Color trailColor = Color.BLACK;
    private int[] xPositions = new int[TRAIL_LENGTH];
    private int[] yPositions = new int[TRAIL_LENGTH];
            
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(backgroundColor);
        this.setForeground(trailColor);
        
        for (int i = 0; i < TRAIL_LENGTH; i++) {
            g.fillPolygon(createTriangle(xPositions[i], yPositions[i]));
        }
    }
    public void updateBackgroundColor(Color color){
        backgroundColor = color;
        this.repaint();
    }

    public void updateTrailColor(Color color) {
        this.trailColor = color;
        this.repaint();
    }

    void updateTrail(int posx, int posy) {
        for (int i = xPositions.length - 1; i > 0; i--) {
            xPositions[i] = xPositions[i-1];
        }
        
        for (int i = yPositions.length - 1; i > 0; i--) {
            yPositions[i] = yPositions[i-1];
            
        }
        
        xPositions[0] = posx;
        yPositions[0] = posy;
        this.repaint();
    }
    
    private Polygon createTriangle(int centerX, int centerY){
        int[] verticesX = new int[3];
        int[] verticesY = new int[3];
        
        int base = 10;
        
        // upper vertice
        verticesX[0] = centerX;
        verticesY[0] = centerY - base / 2;
        
        // left vertice
        verticesX[1] = centerX - base / 2;
        verticesY[1] = centerY + base / 2;
        
        // right vertice
        verticesX[2] = centerX + base / 2;
        verticesY[2] = centerY + base / 2;
        
        return new Polygon(verticesX, verticesY, 3);
    }
}
