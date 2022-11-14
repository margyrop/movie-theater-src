package com.jpmc.theater;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.jpmc.theater.Constants.*;
import static com.jpmc.theater.Constants.MovieCode.SPECIAL;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public double calculateTicketPrice() {
        return Double.parseDouble(df.format(movie.getTicketPrice() - getDiscount()));
    }

    // The Showing should own the discount, since the discount is highly coupled to the Showing time
    private double getDiscount() {
        // 20% discount for the special movie
        double discount = 0;
        if (SPECIAL == movie.getSpecialCode()) {
            discount = movie.getTicketPrice() * SPECIAL_DISCOUNT;  // 20% discount for special movie
        }

        // $3 discount for the movie showing 1st of the day
        if (sequenceOfTheDay == 1) {
            discount = FIRST_OF_DAY_DISCOUNT > discount ? FIRST_OF_DAY_DISCOUNT : discount;
        }
        // $2 discount for the movie showing 2nd of the day
        else if (sequenceOfTheDay == 2) {
            discount = SECOND_OF_DAY_DISCOUNT > discount ? SECOND_OF_DAY_DISCOUNT : discount;
        }

        // Any movies showing starting between 11AM ~ 4pm, you'll get 25% discount (interpreting this as inclusive of 11AM, exclusive of 4PM)
        if (ELEVEN_AM.equals(LocalTime.of(showStartTime.getHour(), showStartTime.getMinute())) ||
            (ELEVEN_AM.isBefore(LocalTime.of(showStartTime.getHour(), showStartTime.getMinute())) &&
             FOUR_PM.isAfter(LocalTime.of(showStartTime.getHour(), showStartTime.getMinute())))) {
            double afternoonDiscount = movie.getTicketPrice() * AFTERNOON_DISCOUNT;
            discount = afternoonDiscount > discount ? afternoonDiscount : discount;

        }

        // Any movies showing on 7th, you'll get 1$ discount
        // Day of month is not 0 indexed
        if (showStartTime.getDayOfMonth() == 7) {
            double discount7th = 1;
            discount = discount7th > discount ? discount7th : discount;

        }

        // biggest discount wins
        return discount;
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

}
