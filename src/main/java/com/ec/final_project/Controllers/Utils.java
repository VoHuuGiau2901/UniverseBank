package com.ec.final_project.Controllers;

import java.sql.Date;
import java.util.Calendar;

public class Utils {
    public static Date getCurrentDate() {
        return new Date(Calendar.getInstance().getTime().getTime());
    }
}
