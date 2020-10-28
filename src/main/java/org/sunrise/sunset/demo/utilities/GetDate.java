package org.sunrise.sunset.demo.utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {

    public static String getToday(){

        Date date = new Date();
        SimpleDateFormat ft =
                new SimpleDateFormat ("yyyy-MM-dd");
        String dateToday =ft.format(date);
        return dateToday;
    }

}
