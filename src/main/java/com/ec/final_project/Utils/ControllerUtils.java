package com.ec.final_project.Utils;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

public class ControllerUtils {
    public static Date getCurrentDate() {
        return new Date(Calendar.getInstance().getTime().getTime());
    }

    public static String Get_OTP() {
        Random r = new Random();
        return String.format("%06d", r.nextInt(999999));
    }
}
