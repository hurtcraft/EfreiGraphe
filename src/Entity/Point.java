package Entity;

public class Point {
    private int x;
    private int y;
    private int stationID;
    public Point(int x, int y, int stationID) {
        this.x = x;
        this.y = y;
        this.stationID = stationID;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getStationID() {
        return stationID;
    }
    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + ", stationID=" + stationID + "]";
    } 
}
