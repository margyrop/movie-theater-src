package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.jpmc.theater.Constants.MovieCode.REGULAR;
import static com.jpmc.theater.Constants.MovieCode.SPECIAL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieTests {
    @Test
    void specialMovieEquals() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, SPECIAL);
        Movie spiderMan2 = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, SPECIAL);
        assertTrue(spiderMan.equals(spiderMan2));

    }

    @Test
    void specialMovieNotEqualsName() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, SPECIAL);
        Movie spiderMan2 = new Movie("Spider-Man: No Way Home 2", Duration.ofMinutes(90),12.5, SPECIAL);
        assertFalse(spiderMan.equals(spiderMan2));
    }

    @Test
    void specialMovieNotEqualsDuration() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, SPECIAL);
        Movie spiderMan2 = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(91),12.5, SPECIAL);
        assertFalse(spiderMan.equals(spiderMan2));
    }
    @Test
    void specialMovieNotEqualsTicketPrice() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, SPECIAL);
        Movie spiderMan2 = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),13.5, SPECIAL);
        assertFalse(spiderMan.equals(spiderMan2));
    }
    @Test
    void specialMovieNotEqualsSpecial() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, SPECIAL);
        Movie spiderMan2 = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, REGULAR);
        assertFalse(spiderMan.equals(spiderMan2));
    }
}
