package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import java.util.Map;

import Entity.Station;
import Utils.MetroDataGetter;
import Utils.Prim;

public class Window {
    private JFrame frame;
    private int menuWidth=200;
    private int mapWidth=1000;
    private int height=900;
    private int width=mapWidth+menuWidth;
    private MetroMap metroMap;
    private Menu menu;
    // 987*952
    public Window(Map<Integer,Station> allStations) throws IOException{
        this.frame= new JFrame("jsp quoi mettre");
        GUIPoint.setWindowDimenson(MetroMap.mapWidth,MetroMap.height);
        iniMetroMap(allStations);
        initMenu();

        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        
        frame.add(metroMap, BorderLayout.CENTER);
        frame.add(menu, BorderLayout.CENTER);
        
    }

    public void initMenu(){
        Dimension d =new Dimension(menuWidth, height);
        this.menu=new Menu(d,metroMap);
    }
    public void iniMetroMap(Map<Integer,Station> allStations) throws IOException{
        Dimension d =new Dimension(MetroMap.mapWidth, height);
        this.metroMap=new MetroMap(d,allStations);
    }


    
}
