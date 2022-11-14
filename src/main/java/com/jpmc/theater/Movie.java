package com.jpmc.theater;

import lombok.Data;

import java.time.Duration;
import java.util.Objects;
import com.jpmc.theater.Constants.MovieCode;

@Data
public class Movie {


    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private MovieCode specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, MovieCode specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}