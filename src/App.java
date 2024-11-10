import java.util.List;
import java.util.Map;

import Entity.Station;
import GUI.Window;

import Utils.MetroDataGetter;

public class App {

    public static void main(String[] args) throws Exception {
        // save();
        String dataFile="src/ressources/cleanedMetro.txt";
        MetroDataGetter.init(dataFile);
        Map<Integer,Station> allStations=MetroDataGetter.getMapOfStation(); 
        new Window(allStations);
        
    }

}
