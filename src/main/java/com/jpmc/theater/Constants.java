package com.jpmc.theater;

import java.time.LocalTime;

public class Constants {

    public static final double SPECIAL_DISCOUNT = 0.20;
    public static final double AFTERNOON_DISCOUNT = 0.25;

    public static final double FIRST_OF_DAY_DISCOUNT = 3;
    public static final double SECOND_OF_DAY_DISCOUNT = 2;


    public static final LocalTime ELEVEN_AM = LocalTime.of(11, 0);
    public static final LocalTime FOUR_PM = LocalTime.of(16, 0);

    public enum MovieCode {
        SPECIAL,
        REGULAR
    }


}
