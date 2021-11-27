package ch.swout;

import org.cactoos.iterable.Mapped;

import javax.json.JsonArray;
import javax.json.JsonObject;

public class PlacesFromJsonArray implements Places {

    private final JsonArray jsonArray;

    public PlacesFromJsonArray(JsonArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    @Override
    public Iterable<Place> iterate() {
        return new Mapped<>(
                place -> new PlaceFromJson((JsonObject) place), //TODO: what if it's not a json object ? what if there is no id key ? what if the id doesn't begin with google: ?
                this.jsonArray
        );
    }
}
