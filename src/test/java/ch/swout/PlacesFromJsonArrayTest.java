package ch.swout;

import org.junit.jupiter.api.Test;

import javax.json.Json;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class PlacesFromJsonArrayTest {

    @Test
    void iterate() { //TODO: rename
        assertThat(
                new PlacesFromJsonArray(
                        Json.createArrayBuilder()
                                .add(Json.createObjectBuilder().add("id", "google:b-BBu5"))
                                .add(Json.createObjectBuilder().add("id", "google:VlIFPDq"))
                                .add(Json.createObjectBuilder().add("id", "google:DqWJhc3Rv"))
                                .build()
                ).iterate(),
                contains(
                        new PlaceConst("google:b-BBu5"),
                        new PlaceConst("google:VlIFPDq"),
                        new PlaceConst("google:DqWJhc3Rv")
                )
        );
    }
}