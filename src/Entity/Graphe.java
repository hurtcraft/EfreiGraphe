package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graphe {
    private Map<Integer,List<Arete>> graphe;


    public Graphe(){
        this.graphe=new HashMap<>();
    }

    public void add(int source,int dest,int tempsTrajet){
        
        this.graphe.putIfAbsent(source, new ArrayList<>());
        this.graphe.get(source).add(new Arete(source, dest, tempsTrajet));
    }
    public List<Arete> getListAretes(int source){
        return this.graphe.get(source);
    }
    public Set<Integer> getSommets(){
        return graphe.keySet();
    }
    public int getNbSommet(){
        return graphe.size();
    }

    public Map<Integer,List<Arete>> getGraphe(){
        return graphe;
    }

    @Override
    public String toString() {
        return "Graphe [graphe=" + graphe + "]";
    }
    
}
