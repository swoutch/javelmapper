package ch.swout;

import javax.json.Json;
import javax.json.JsonReader;
import java.io.StringReader;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class JourneyFromJsonStringTest {

    @org.junit.jupiter.api.Test
    void duration() throws Exception { //todo: rename test to something meaningful
        String jsonString = "{\"duration_seconds\": 1228}";
        JsonReader jsonReader = Json.createReader(new StringReader("{\"duration_seconds\": 1228}"));
        Duration actual = new JourneyFromJsonString(jsonString).duration();
        Duration expected = Duration.ofSeconds(1228);
        assertEquals(actual, expected);
    }
}