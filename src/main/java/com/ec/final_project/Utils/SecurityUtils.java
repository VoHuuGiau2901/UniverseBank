package com.ec.final_project.Utils;

import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class SecurityUtils {
    public static final Algorithm ENCODE_ALGORITHM = Algorithm.HMAC256("SECRET_KEY".getBytes());

    public static final Date ACCESS_TIME_EXPIRED = new Date(System.currentTimeMillis() +  30 * 1000);

    public static final Date REFRESH_TIME_EXPIRED = new Date(System.currentTimeMillis() + 60 * 1000);

}
