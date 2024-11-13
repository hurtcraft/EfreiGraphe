package Utils;

import java.util.*;

import Entity.Arete;
import Entity.Graphe;

public class Prim {
    
    public static Graphe execute(Graphe g) {
        int start = 0; 
        PriorityQueue<Arete> priorityQ = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        Graphe g2 = new Graphe(); 
        int sum = 0;

        visited.add(start);
        priorityQ.addAll(g.getListAretes(start));

        while (!priorityQ.isEmpty()) {
            Arete currentArete = priorityQ.poll();
            
            int sommet1 = currentArete.getStation1();
            int sommet2 = currentArete.getStation2();
            int nouveauSommet = -1;

            if (visited.contains(sommet1) && !visited.contains(sommet2)) {
                nouveauSommet = sommet2;
            } else if (visited.contains(sommet2) && !visited.contains(sommet1)) {
                nouveauSommet = sommet1;
            }

            if (nouveauSommet == -1) {
                continue; 
            }

            g2.add(sommet1, sommet2, currentArete.getTempsTrajet());
            visited.add(nouveauSommet);
            sum += currentArete.getTempsTrajet();
            priorityQ.addAll(g.getListAretes(nouveauSommet));
        }

        System.out.println("SUM PRIM : " + sum);

        return g2;
    }
}
