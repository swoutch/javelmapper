package ch.swout;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PlaceFromQuery implements Place {

    private final String query;

    public PlaceFromQuery(String query) {
        this.query = query;
    }

    @Override
    public String id() throws Exception {
        final HttpClient client = HttpClient.newBuilder().build();
        final String requestBody = "{\"query\": \"" + this.query + "\",\"region_id\":\"fr-paris\",\"is_refinement\":true,\"refinement_data\":{\"is_chain\":true},\"powersearch\":false}";
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://citymapper.com/api/4/searchpost"))
                .header("citymapper-region", "fr-paris")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        System.out.println(request); //todo: replace by logging
        final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        final String responseBody = response.body();
        JsonArray results = JsonParser.object().from(responseBody).getArray("results");
        for (Object result : results) {
            final String googleMapsPlaceId = ((JsonObject) result).getString("id", "");
            if (googleMapsPlaceId.startsWith("google:")) {
                return googleMapsPlaceId;
            }
        }
        throw new Exception();
    }
}
