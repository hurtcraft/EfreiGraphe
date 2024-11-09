package Utils;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import Entity.Arete;
import Entity.Graphe;
import Entity.SourceAndWeight;

public class Prim {
    
    public static Graphe execute(Graphe g){
        int start = 0;
        int currentSommet=start;
        List<Arete> listAretes=g.getListAretes(currentSommet);
        PriorityQueue<Arete> priorityQ=new PriorityQueue<>();
        Set<Integer>visited=new HashSet<>();
        priorityQ.addAll(listAretes);
        // visited.add(currentSommet);
        Graphe g2=new Graphe();
        Arete currentArete;
        while (!priorityQ.isEmpty()) {
            currentArete=priorityQ.poll();
            currentSommet=currentArete.getStation2();
            if(visited.contains(currentSommet)){
                continue;
            }

            priorityQ.addAll(g.getListAretes(currentSommet));
            
            
            g2.add(currentArete.getStation1(), currentArete.getStation2(), currentArete.getTempsTrajet());
            visited.add(currentSommet);
        
        }
        return g2;
        
    }


}
