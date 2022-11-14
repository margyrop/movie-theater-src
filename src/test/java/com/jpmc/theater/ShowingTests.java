package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static com.jpmc.theater.Constants.MovieCode.REGULAR;
import static com.jpmc.theater.Constants.MovieCode.SPECIAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowingTests {
    // One test per combination of discounts

    @Test
    void totalFeeSpecialAndFirstOfDay() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL),
                1,
                LocalDateTime.of(2022, 11, 15, 7, 20)
        );
        assertEquals(showing.calculateTicketPrice(), 9.5);
    }

    @Test
    void totalFeeSpecialAndSecondOfDay() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL),
                2,
                LocalDateTime.of(2022, 11, 15, 7, 20)
        );
        assertEquals(showing.calculateTicketPrice(), 10);
    }

    @Test
    void totalFeeRegularAndFirstOfDay() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, REGULAR),
                1,
                LocalDateTime.of(2022, 11, 15, 7, 20)
        );
        assertEquals(showing.calculateTicketPrice(), 9.5);
    }

    @Test
    void totalFeeRegularAndSecondOfDay() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, REGULAR),
                2,
                LocalDateTime.of(2022, 11, 15, 7, 20)
        );
        assertEquals(showing.calculateTicketPrice(), 10.5);
    }

    @Test
    void totalFeeSpecialAndNotFirstOrSecondOfDay() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL),
                3,
                LocalDateTime.of(2022, 11, 15, 7, 20)
        );
        assertEquals(showing.calculateTicketPrice(), 10);
    }

    @Test
    void totalFeeRegularAndNotFirstOrSecondOfDay() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, REGULAR),
                3,
                LocalDateTime.of(2022, 11, 15, 7, 20)
        );
        assertEquals(showing.calculateTicketPrice(), 12.5);
    }

    @Test
    void totalFeeSpecialAndFirstOfDayAndStartsAt11am() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL),
                1,
                LocalDateTime.of(2022, 11, 15, 11, 0)
        );
        assertEquals(showing.calculateTicketPrice(), 9.38);
    }

    @Test
    void totalFeeSpecialAndFirstOfDayAndStartsAt4pm() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL),
                1,
                LocalDateTime.of(2022, 11, 15, 16, 0)
        );
        assertEquals(showing.calculateTicketPrice(), 9.5);
    }

    @Test
    void totalFeeSpecialAndFirstOfDayAndStartsBetween11amAnd4pm() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, SPECIAL),
                1,
                LocalDateTime.of(2022, 11, 15, 15, 59)
        );
        assertEquals(showing.calculateTicketPrice(), 9.38);
    }

    @Test
    void totalFeeRegularAndNotFirstOrSecondOfDayAndStartsBefore11amOn7th() {
        Showing showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, REGULAR),
                3,
                LocalDateTime.of(2022, 11, 7, 7, 0)
        );
        assertEquals(showing.calculateTicketPrice(), 11.5);
    }
}
