package ch.swout;

import com.grack.nanojson.JsonParserException;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class JourneyFromJsonStringTest {

    @org.junit.jupiter.api.Test
    void duration() throws JsonParserException { //todo: rename test to something meaningful
        String json = "{\"duration_seconds\": 1228}";
        Duration actual = new JourneyFromJsonString(json).duration();
        Duration expected = Duration.ofSeconds(1228);
        assertEquals(actual, expected);
    }
}