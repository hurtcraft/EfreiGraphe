package Entity;

public class SourceAndWeight implements Comparable<SourceAndWeight>{
    private int source;
    private int ponderation;
    private int current;
    
    public SourceAndWeight(int source, int ponderation,int current) {
        this.source = source;
        this.ponderation = ponderation;
        this.current=current;
    }
    public int getSource() {
        return source;
    }
    public void setSource(int source) {
        this.source = source;
    }
    public int getPonderation() {
        return ponderation;
    }
    public void setPonderation(int ponderation) {
        this.ponderation = ponderation;
    }


    @Override
    public int compareTo(SourceAndWeight other) {
        return Integer.compare(this.ponderation, other.ponderation);
    }
    public int getCurrent() {
        return current;
    }
    public void setCurrent(int current) {
        this.current = current;
    }
    @Override
    public String toString() {
        return "SourceAndWeight [source=" + source + ", ponderation=" + ponderation + ", current=" + current + "]";
    }
}
