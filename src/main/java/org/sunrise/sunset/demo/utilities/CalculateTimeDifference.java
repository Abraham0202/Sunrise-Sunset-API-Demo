package org.sunrise.sunset.demo.utilities;

import sun.rmi.runtime.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateTimeDifference {

    public static String calculateTime(String sunrise, String sunset){
        long diffHours=0;
        long diffMinutes=0;
        long diffSeconds=0;
        String minutes="";
        String second="";
        try {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss aa");
            Date date1 = format.parse(sunrise);
            Date date2 = format.parse(sunset);
            long diff = date2.getTime() - date1.getTime();

             diffSeconds = diff / 1000 % 60;
            diffMinutes = diff / (60 * 1000) % 60;
            diffHours = diff / (60 * 60 * 1000) % 24;
             if(diffMinutes<10){
                 minutes="0"+diffMinutes;
             }else{
                 minutes=String.valueOf(diffMinutes);
             }
            if(diffSeconds<10){
                second="0"+diffSeconds;
            }else{
                second=String.valueOf(diffSeconds);
            }



        }catch (Exception e){
            e.printStackTrace();
        }
        String time=""+diffHours+":"+minutes+":"+second;
        return time ;
    }

}
