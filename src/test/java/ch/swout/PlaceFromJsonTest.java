package ch.swout;

import org.junit.jupiter.api.Test;

import javax.json.Json;

import static org.junit.jupiter.api.Assertions.*;

class PlaceFromJsonTest {

    @Test
    void id() {
        assertEquals(
                "google:ChIJfX8b-BBu5kcR28va9RRKVzM",
                new PlaceFromJson(
                        Json.createObjectBuilder().add("id", "google:ChIJfX8b-BBu5kcR28va9RRKVzM").build()
                ).id()
        );
    }
}