package Entity;

public class Station extends MetroComponent
{
    private int numStation;
    private String nom;
    private String numLigne; // ==> a cause des lignes bis
    private boolean isTerminus;
    private int nbBranchement;
    public Station(int numStation, String nom, String numLigne, boolean isTerminus, int nbBranchement) {
        this.numStation = numStation;
        this.nom = nom;
        this.numLigne = numLigne;
        this.isTerminus = isTerminus;
        this.nbBranchement = nbBranchement;
    }
    public int getNumStation() {
        return numStation;
    }
    public void setNumStation(int numStation) {
        this.numStation = numStation;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNumLigne() {
        return numLigne;
    }
    public void setNumLigne(String numLigne) {
        this.numLigne = numLigne;
    }
    public boolean isTerminus() {
        return isTerminus;
    }
    public void setTerminus(boolean isTerminus) {
        this.isTerminus = isTerminus;
    }
    public int getNbBranchement() {
        return nbBranchement;
    }
    public void setNbBranchement(int nbBranchement) {
        this.nbBranchement = nbBranchement;
    }
    @Override
    public String toString() {
        return "Station [numStation=" + numStation + ", nom=" + nom + ", numLigne=" + numLigne + ", isTerminus="
                + isTerminus + ", nbBranchement=" + nbBranchement + "]";
    }
    
}
