package ch.swout;

public class Main {
    public static void main(String[] args) throws Exception {
//        new JourneyFromJsonString(
//                new JdkRequest("https://citymapper.com/api/7/journeys?region_id=fr-paris&include_stepfree=1")
//                        .uri()
//                        .queryParam("start", new CoordinatesConst(new CoordinatesFromGoogleMapsPlace("")))
//                        .end("end", )
//        )
        final Place startway_place = new PlaceConst(new PlaceFromQuery("startway coworking sentier").id());
        System.out.println(startway_place.id());

        System.out.println(new LocationFromPlace(startway_place).coordinates());
    }
}
