package ch.swout;

import com.grack.nanojson.JsonParser;

public class PlaceFromJsonString implements Place {

    private final String json;

    public PlaceFromJsonString(String json) {
        this.json = json;
    }

    @Override
    public String id() throws Exception {
        return JsonParser.object().from(this.json).getString("id");
    }
}
