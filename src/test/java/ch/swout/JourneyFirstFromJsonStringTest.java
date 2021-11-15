package ch.swout;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class JourneyFirstFromJsonStringTest {

    @org.junit.jupiter.api.Test
    void duration() { //todo: rename test to something meaningful
        String json = "{\"journeys\": [{\"duration_seconds\": 1228},{\"duration_seconds\": 2000}]}";
        Duration actual = new JourneyFirstFromJsonString(json).duration();
        Duration expected = Duration.ofSeconds(1228);
        assertEquals(actual, expected);
    }
}