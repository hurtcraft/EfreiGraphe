package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import Entity.Arete;
import Entity.Graphe;
import Entity.Station;
import Utils.MetroDataGetter;
import Utils.PointNormalizer;

public class PrimGUI extends JPanel {
    private List<int[]> edgesToDraw; // Liste pour stocker les coordonnées des arêtes
    private boolean shouldDraw=false;
    public PrimGUI(Graphe g) {
        edgesToDraw = new ArrayList<>(); // Initialise la liste
        Map<Integer, List<Arete>> mapOfIndex = g.getGraphe();
        Map<Integer, Station> mapOfStation = MetroDataGetter.getMapOfStation();

        // Parcours des arêtes et stockage des coordonnées pour le dessin
        for (int stationIndex : mapOfIndex.keySet()) {
            List<Arete> lstArete = mapOfIndex.get(stationIndex);
            for (Arete arete : lstArete) {
                int indexS1 = arete.getStation1();
                int indexS2 = arete.getStation2();
                Station s1 = mapOfStation.get(indexS1);
                Station s2 = mapOfStation.get(indexS2);

                int x1 = s1.getX();
                int y1 = s1.getY()-65;//tkt
                int x2 = s2.getX();
                int y2 = s2.getY()-65;

                edgesToDraw.add(new int[]{x1, y1, x2, y2});
            }
        }
        setOpaque(false);
    }
    public void draw(boolean b){
        shouldDraw=b;

        if (shouldDraw) {
            setVisible(true);  // Rendre le panneau visible si shouldDraw est true
        } else {
            setVisible(false);  // Cacher le panneau si shouldDraw est false
        }
        
        repaint();  // Rafraîchir le panneau
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN); // Définit la couleur verte pour le dessin
        if(shouldDraw){
            Graphics2D g2d = (Graphics2D) g;
            
            g2d.setColor(Color.GREEN); // Définit la couleur verte pour le dessin
            
            // Épaisseur du trait (par exemple, 3 pixels)
            g2d.setStroke(new BasicStroke(3));            // Dessine chaque arête (ligne) stockée dans edgesToDraw
            for (int[] edge : edgesToDraw) {
                int x1 = edge[0];
                int y1 = edge[1];
                int x2 = edge[2];
                int y2 = edge[3];
                g.drawLine(x1, y1, x2, y2); // Dessine la ligne entre les points (x1, y1) et (x2, y2)

            }
        }

    }
}
