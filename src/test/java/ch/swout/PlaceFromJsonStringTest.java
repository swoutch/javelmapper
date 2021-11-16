package ch.swout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceFromJsonStringTest {

    @Test
    void id() throws Exception {
        assertEquals(
                "google:ChIJfX8b-BBu5kcR28va9RRKVzM",
                new PlaceFromJsonString(
                        "{\"id\":\"google:ChIJfX8b-BBu5kcR28va9RRKVzM\"}"
                ).id()
        );
    }
}