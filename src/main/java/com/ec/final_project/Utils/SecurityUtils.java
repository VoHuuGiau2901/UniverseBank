package com.ec.final_project.Utils;

import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class SecurityUtils {
    public static Algorithm ENCODE_ALGORITHM() {
        return Algorithm.HMAC256("SECRET_KEY".getBytes());
    }

    public static Date TIME_EXPIRED(){
        return new Date(System.currentTimeMillis()+10*60*1000);
    }

}
