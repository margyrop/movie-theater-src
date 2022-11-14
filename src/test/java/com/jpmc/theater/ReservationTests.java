package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static com.jpmc.theater.Constants.MovieCode.REGULAR;
import static com.jpmc.theater.Constants.MovieCode.SPECIAL;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    // Only logic in Reservation is totalPrice, so only one test needed.
    @Test
    void totalFeeSpecialAndFirstOfDay() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL),
                1,
                LocalDateTime.of(2022, 11, 15, 7, 20)
        );
        assertTrue(new Reservation(customer, showing, 3).totalFee() == 28.5);
    }

}
