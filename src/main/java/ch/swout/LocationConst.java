package ch.swout;

public class LocationConst implements Location {

    private final Coordinates coordinates;

    public LocationConst(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Coordinates coordinates() {
        return this.coordinates;
    }
}
