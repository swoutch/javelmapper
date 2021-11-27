package ch.swout;

import com.grack.nanojson.JsonParser;

import javax.json.JsonObject;

public class PlaceFromJson implements Place {

    private final JsonObject json;

    public PlaceFromJson(JsonObject json) {
        this.json = json;
    }

    @Override
    public String id() {
        return this.json.getString("id"); //TODO: what if jso has no id key ? what if id does not begin with google: ?
    }

    @Override
    public boolean equals(Object obj) {
        final boolean same;
        if (obj instanceof Place) {
            try {
                return ((Place) obj).id().equals(this.id());
            } catch (Exception e) {
                throw new RuntimeException("Exception occured during comparison of 2 place id", e); //TODO: use EqPlace pattern described in kirill blog
            }
        } else {
            return false;
        }
    }
}
