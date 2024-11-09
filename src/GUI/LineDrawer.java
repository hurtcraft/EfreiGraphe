package GUI;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LineDrawer extends JPanel {

    private int x1, y1, x2, y2;

    public LineDrawer(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(x1, y1, x2, y2);
    }

    // public static void main(String[] args) {
    //     JFrame frame = new JFrame("Dessiner une droite");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(400, 400);
        
    //     LineDrawer linePanel = new LineDrawer(50, 50, 300, 300);
        
    //     frame.add(linePanel);
    //     frame.setVisible(true);
    // }
}