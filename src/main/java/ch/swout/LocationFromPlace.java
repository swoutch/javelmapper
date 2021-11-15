package ch.swout;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LocationFromPlace implements Location {

    private final Place place;

    public LocationFromPlace(Place place) {
        this.place = place;
    }

    @Override
    public Coordinates coordinates() throws Exception {
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://citymapper.com/api/1/placeresolve?region_id=fr-paris&id=" + this.place.id()))
                .GET()
                .build();
        System.out.println(request); //todo: replace by logging
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        final String responseBody = response.body();
        JsonArray coords = JsonParser.object().from(responseBody).getObject("place_result").getArray("coords");
        if (coords.size() == 2) {
            return new CoordinatesConst((double) coords.get(0), (double) coords.get(1));
        }
        throw new Exception();
    }
}
