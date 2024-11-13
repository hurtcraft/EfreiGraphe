package Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import javax.xml.transform.Source;

import Entity.Arete;
import Entity.Graphe;
import Entity.SourceAndWeight;

public class Dijsktra {
    
    public static Map<Integer,SourceAndWeight> execute(Graphe g,int source){
        Map<Integer,SourceAndWeight>workingMap=init(g,source);

        PriorityQueue<SourceAndWeight> priorityQueue=new PriorityQueue<>();
        int currentSommet;
        List<Arete> listAretes;
        priorityQueue.add(workingMap.get(source));
        Set<Integer>visited=new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            currentSommet=priorityQueue.poll().getCurrent();
            if(visited.contains(currentSommet)){
                continue;
            }

            listAretes=g.getListAretes(currentSommet);
            updateWeight(listAretes, workingMap,priorityQueue);
            visited.add(currentSommet);
            
        }
        // System.out.println(workingMap);
        return workingMap;
    }
    public static List<SourceAndWeight> getShortestPath(Graphe g, int source,int dest){
        Map<Integer,SourceAndWeight> workingMap=execute(g, source);
        List<SourceAndWeight> lst=new ArrayList<>();
        int tmp=dest;
        while (tmp!=source) {
            lst.add(workingMap.get(tmp));

            tmp=workingMap.get(tmp).getSource();
        }
        lst.add(workingMap.get(tmp));
        return lst;
    }
    public static void printShortestPath(Graphe g,int source, int dest){
        List<SourceAndWeight> lst=getShortestPath(g,source, dest);
        int finalWeight=lst.get(0).getPonderation();
        Collections.reverse(lst);
        SourceAndWeight sourceAndWeight;
        int tmpSource;
        int tmpDest;
        int tmpWeight;

        int count=0;
        System.out.println("###########################################################");
        System.out.println("[SOURCE] "+MetroDataGetter.getMapOfStation().get(source).getNom());
        System.out.println("[DESTINATION] "+MetroDataGetter.getMapOfStation().get(dest).getNom());
        System.out.println("###########################################################");
        for (int i = 0; i < lst.size(); i++) {
            
            sourceAndWeight=lst.get(i);
            tmpSource=sourceAndWeight.getSource();
            tmpDest=sourceAndWeight.getCurrent();
            tmpWeight=sourceAndWeight.getPonderation()-count;
            System.out.print(String.format(" --%d--> [%d]",tmpWeight,tmpDest));
            count+=tmpWeight;
        }

        System.out.println(System.lineSeparator()+"[TOTAL TEMPS] : "+finalWeight+" sec soit environ : "+finalWeight/60+" min");
        System.out.println("###########################################################");

    }
    private static void updateWeight(List<Arete> listAretes,Map<Integer,SourceAndWeight>workingMap,PriorityQueue<SourceAndWeight> priorityQueue){
        int sourceSommet;
        int destSommet;

        int sourceWeight;
        int currentWeight;
        int newWeight;

        SourceAndWeight sourceAndWeightOf_Source;
        SourceAndWeight sourceAndWeightOf_Destination;

        for (Arete arete : listAretes) {
            sourceSommet=arete.getStation1();
            destSommet=arete.getStation2();

            sourceAndWeightOf_Source=workingMap.get(sourceSommet);
            sourceAndWeightOf_Destination=workingMap.get(destSommet);


            sourceWeight=sourceAndWeightOf_Source.getPonderation();
            newWeight=sourceWeight+arete.getTempsTrajet();

            currentWeight=sourceAndWeightOf_Destination.getPonderation();

            if(newWeight<currentWeight){
                sourceAndWeightOf_Destination.setPonderation(newWeight);
                sourceAndWeightOf_Destination.setSource(sourceSommet);
            }
            priorityQueue.add(sourceAndWeightOf_Destination);
            //System.out.println(sourceAndWeightOf_Destination);
        }
    }
    private static Map<Integer,SourceAndWeight>init(Graphe g,int source){
        Map<Integer,SourceAndWeight> map=new HashMap<>();
        for (Integer sommet: g.getSommets() ) {
            map.put(sommet, new SourceAndWeight(-1, Integer.MAX_VALUE,sommet));
        }
        //on commence par la station 0
        map.get(source).setSource(0);
        map.get(source).setPonderation(0);
        return map;
    }
}
