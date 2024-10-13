package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Entity.Graphe;
import Entity.Station;

public class GrapheChecker {
    
    public static List<Integer> getSommetIsole(Graphe g, Set<Integer> allStationID){
        List<Integer> res=new ArrayList<>();
        Set<Integer> gSet=g.getSommets();
        for (Integer stationID : allStationID) {
            if(!gSet.contains(stationID)){
                res.add(stationID);
            }
        }
        return res;
    }
    public static boolean isConnexe(Graphe g, Set<Integer> allStationID){
        return getSommetIsole(g, allStationID).size()==0;
    }
}
