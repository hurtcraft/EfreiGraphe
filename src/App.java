import java.util.List;
import java.util.Map;

import Entity.Arete;
import Entity.Graphe;
import Entity.MetroComponent;
import Entity.SourceAndWeight;
import Entity.Station;
import Utils.Belleman;
import Utils.GrapheChecker;
import Utils.MetroDataGetter;

public class App {
    public static void main(String[] args) throws Exception {
        String dataFile="ressources\\metro.txt";
        MetroDataGetter.init(dataFile);

        Graphe graphe=MetroDataGetter.getGraphe();
        Map<Integer,Station> allStations=MetroDataGetter.getMapOfStation();
        
        
        //  Map<Integer,SourceAndWeight> map=Belleman.execute(graphe);
        //  Belleman.printShortestPath(graphe,0,365 );  

        // System.out.println(Belleman.execute(graphe, 1));
        Belleman.printShortestPath(graphe,48,365 );  
        // Belleman.printShortestPath(graphe,0, 5);
        // // System.out.println(GrapheChecker.isConnexe(graphe, allStations.keySet()));
    }
}
