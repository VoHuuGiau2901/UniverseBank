package com.ec.final_project.Utils;

import java.sql.Date;
import java.util.Calendar;

public class ControllerUtils {
    public static Date getCurrentDate() {
        return new Date(Calendar.getInstance().getTime().getTime());
    }
}
