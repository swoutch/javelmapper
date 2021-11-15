package ch.swout;

public class CoordinatesConst implements Coordinates {

    private double lat;
    private double lon;

    public CoordinatesConst(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public double latitude() {
        return this.lat;
    }

    @Override
    public double longitude() {
        return this.lon;
    }

    @Override
    public String toString() {
        return this.lat + "," + this.lon;
    }

}
