package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Entity.Station;

import java.util.Map;
public class MetroMap extends JPanel {
    private Image img;
    public static final int mapWidth=1000;
    public static final int height=900;
    private static final String imgPath="ressources\\metro2k.png"; 
    public MetroMap(Dimension dimension, Map<Integer,Station> allStations) throws IOException{
        setSize(dimension);
        img = ImageIO.read(new File(imgPath));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, -10, mapWidth, height, this);
    }


}
