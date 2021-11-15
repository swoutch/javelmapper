package ch.swout;

public class PlaceConst implements Place {

    private final String id;

    public PlaceConst(String id) {
        this.id = id;
    }

    @Override
    public String id() throws Exception {
        return this.id;
    }
}
