package Entity;

public class SelectedStation {
    private Station station;
    private boolean isSelected;
    
    public SelectedStation(Station station, boolean isSelected) {
        this.station = station;
        this.isSelected = isSelected;
    }
    public Station getStation() {
        return station;
    }
    public void setStation(Station station) {
        this.station = station;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    @Override
    public String toString() {
        return "SelectedStation [station=" + station + ", isSelected=" + isSelected + "]";
    }

    
}
