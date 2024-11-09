package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Entity.Arete;
import Entity.Graphe;
import Entity.SourceAndWeight;
import Entity.Station;
import Utils.Belleman;
import Utils.MetroDataGetter;
import Utils.Prim;

import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;

public class MetroMap extends JPanel {
    private Image img;
    public static final int mapWidth = 1000;
    public static final int height = 950;
    private static final String imgPath = "ressources\\metrof_r.png"; 

    private static Station stationSource;
    private static Station stationDest;
    private static int nbBtnClicked = 0;

    private ArrayList<GUIPoint> clickedPoints = new ArrayList<>();
    private Map<Integer,GUIPoint> mapIDStationToPoint;
    private Graphe graphe;

    public MetroMap(Dimension dimension, Map<Integer, Station> allStations) throws IOException {
        setSize(dimension);
        setLayout(null);
        this.mapIDStationToPoint=new HashMap();
        this.graphe=MetroDataGetter.getGraphe();
        img = ImageIO.read(new File(imgPath));
        initButtons(allStations);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, -40, mapWidth, height, this);
    }

    private void initButtons(Map<Integer, Station> allStations) {
        for (Integer idStation : allStations.keySet()) {
            Station s = allStations.get(idStation);
            GUIPoint gp = new GUIPoint(s);
            gp.setStationClickListener(new StationClickListener() {
                @Override
                public void onStationClick(Station station) {
                    if (nbBtnClicked == 0) {
                        stationSource = s;
                        nbBtnClicked++;
                        markPoint(gp);

                        clickedPoints.add(gp);         
                    } else if (nbBtnClicked == 1) {
                        stationDest = s;
                        nbBtnClicked++;
                        markPoint(gp);
                        clickedPoints.add(gp); 
                        List<SourceAndWeight> lstAretes=Belleman.getShortestPath(graphe, stationSource.getNumStation(), stationDest.getNumStation());              
                        drawPoint(lstAretes);
                    } 
                    else{
                        resetStations();
                    }

                    // System.out.println("Station cliquée: " + station);
                }
            });
            mapIDStationToPoint.put(idStation, gp);
            this.add(gp);
        }
        repaint();
    }
    public static void drawPrim(Graphe g){
        Graphe primGraphe=Prim.execute(g);
        Map<Integer,List<Arete>>  map=primGraphe.getGraphe();
        for (Integer station : map.keySet()) {
            List<Arete>lstArete=map.get(station);
            for (Arete arete : lstArete) {
                Station s1=MetroDataGetter.getMapOfStation().get(arete.getStation1());
                Station s2=MetroDataGetter.getMapOfStation().get(arete.getStation2());
                // GUIPoint gp1=new GUIPoint(s1);
                // GUIPoint gp2=new GUIPoint(s2);
                // drawArete(gp1, gp2);
                
            }
        }


    } 
    private void resetStations() {
        for (GUIPoint gp : clickedPoints) {
            gp.setIsClicked(false);
            gp.setContentAreaFilled(false); // Désactiver le remplissage
            gp.setBackground(null);         // Réinitialiser la couleur
        }
        clickedPoints.clear();              // Vider la liste des points cliqués
        nbBtnClicked = 0;                   // Réinitialiser le compteur
        stationDest = null;
        stationSource = null;
    }
    private void markPoint(GUIPoint gp){
        gp.setContentAreaFilled(true);
        gp.setIsClicked(true);
        gp.setBackground(Color.RED);
        clickedPoints.add(gp); 
    }
    private static void drawArete(GUIPoint gp1,GUIPoint gp2){
        int x1=gp1.getX();
        int x2=gp2.getX();
        int y1=gp1.getY();
        int y2=gp2.getY();
        LineDrawer ld=new LineDrawer(x1, y1, x2, y2);
        
        return;
    }
    private void drawPoint(List<SourceAndWeight> lstAretes){
        System.out.println("lst source "+lstAretes);
        int source;
        int dest;
        GUIPoint gp1=null;
        GUIPoint gp2=null;


        for (SourceAndWeight sourceAndWeight : lstAretes) {
            source=sourceAndWeight.getSource();
            
            if(source!=0){
                markPoint(mapIDStationToPoint.get(source));

            }
            
        }
    }
}
