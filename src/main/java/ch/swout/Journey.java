package ch.swout;

import com.grack.nanojson.JsonParserException;

import java.time.Duration;

public interface Journey {
    Duration duration() throws JsonParserException;
}
