package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Builder.MetroComponentFactory;
import Entity.Arete;
import Entity.Graphe;
import Entity.MetroComponent;
import Entity.Station;

public class MetroDataGetter {
    private static Map<Integer,Station> map;
    private static List<Arete> areteList;
    private static Graphe graphe;

    public static void init(String pathToDataFile){
        map=new HashMap<>();
        areteList=new ArrayList();
        graphe=new Graphe();
        read(pathToDataFile);
    }
    private static void read(String path){
        try (FileReader fileReader = new FileReader(path,StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            MetroComponent mc;
            Station s;
            Arete a;
            while ((line = bufferedReader.readLine()) != null) {
                mc=MetroComponentFactory.createMetroComponent(line);
                if(mc instanceof Station){
                    s=(Station)mc;
                    map.put(s.getNumStation(), s);
                }
                else if(mc instanceof Arete){
                    a=(Arete)mc;
                    areteList.add(a);
                    graphe.add(a.getStation1(), a.getStation2(),a.getTempsTrajet());
                    graphe.add(a.getStation2(), a.getStation1(),a.getTempsTrajet());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static Map<Integer,Station> getMapOfStation(){
        return map;
    }
    public static List<Arete> getListArete(){
        return areteList;
    }
    public static Graphe getGraphe(){
        return graphe;
    }
}
