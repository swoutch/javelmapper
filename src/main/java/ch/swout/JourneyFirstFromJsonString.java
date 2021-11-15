package ch.swout;

import jsonvalues.JsObj;

import java.time.Duration;

public class JourneyFirstFromJsonString implements Journey {

    private final String json;

    public JourneyFirstFromJsonString(String json) {
        this.json = json;
    }

    @Override
    public Duration duration() {
        return Duration.ofSeconds(
                JsObj.parse(this.json)
                        .getArray("journeys") // todo: handle missing key case and not array case
                        .getObj(0) // todo: handle empty array and not obj case
                        .getInt("duration_seconds") // todo: handle missing key case and not int case and negative case
        );
    }
}
