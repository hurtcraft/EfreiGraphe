import java.util.List;
import java.util.Map;

import Entity.Arete;
import Entity.Graphe;
import Entity.MetroComponent;
import Entity.SourceAndWeight;
import Entity.Station;
import GUI.Window;
import Utils.Belleman;
import Utils.GrapheChecker;
import Utils.MetroDataGetter;
import Utils.Prim;

public class App {

    public static void main(String[] args) throws Exception {
        // save();
        
        String dataFile="ressources\\cleanedMetro.txt";
        MetroDataGetter.init(dataFile);
        Map<Integer,Station> allStations=MetroDataGetter.getMapOfStation(); 
        new Window(allStations);
        
    
    
        
    }

}
