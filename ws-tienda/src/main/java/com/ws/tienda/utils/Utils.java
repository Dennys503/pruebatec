package com.ws.tienda.utils;

import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

/**
 */
public class Utils {

    public final static RoundingMode RM = RoundingMode.HALF_EVEN;
   
    public static Date getCurrentDate() {
        Calendar time = Calendar.getInstance();
        time.add(Calendar.DAY_OF_MONTH, 0);
        return time.getTime();
    }

   
}
