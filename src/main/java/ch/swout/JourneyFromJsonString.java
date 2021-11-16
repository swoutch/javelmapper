package ch.swout;

import com.grack.nanojson.JsonParser;
import com.grack.nanojson.JsonParserException;

import java.time.Duration;

public class JourneyFromJsonString implements Journey {

    private final String json;

    public JourneyFromJsonString(String json) {
        this.json = json;
    }

    @Override
    public Duration duration() throws JsonParserException {
        return Duration.ofSeconds(
                JsonParser.object()
                        .from(this.json)
                        .getInt("duration_seconds") // todo: handle missing key case and not int case and negative case
        );
    }
}
