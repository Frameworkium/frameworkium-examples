package restfulbooker.api.dto.booking.search;

import restfulbooker.api.dto.booking.Booking;

import java.util.Map;

public class SearchParamsMapper {

    private SearchParamsMapper() {
        // hide constructor of mapper
    }

    public static Map<String, String> namesOfBooking(Booking booking) {
        return Map.of(
                "firstname", booking.firstname,
                "lastname", booking.lastname);
    }

    public static Map<String, String> datesOfBooking(Booking booking) {
        return Map.of(
                "checkin", booking.bookingdates.checkin,
                "checkout", booking.bookingdates.checkout);
    }
}
