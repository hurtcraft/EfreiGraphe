package Entity;

public class Arete extends MetroComponent{
    private int station1;
    private int station2;
    private int tempsTrajet;

    public Arete(int station1, int station2, int tempsTrajet) {
        this.station1 = station1;
        this.station2 = station2;
        this.tempsTrajet = tempsTrajet;
    }
    public int getStation1() {
        return station1;
    }
    public void setStation1(int station1) {
        this.station1 = station1;
    }
    public int getStation2() {
        return station2;
    }
    public void setStation2(int station2) {
        this.station2 = station2;
    }
    public int getTempsTrajet() {
        return tempsTrajet;
    }
    public void setTempsTrajet(int tempsTrajet) {
        this.tempsTrajet = tempsTrajet;
    }
    @Override
    public String toString() {
        return "Aretes [station1=" + station1 + ", station2=" + station2 + ", tempsTrajet=" + tempsTrajet + "]";
    }
}
