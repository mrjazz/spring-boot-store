package com.sheremetov.store.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by denis on 10/21/2015.
 */
public class DateTime {

    public static long getUnixTime() {
        Date date= new java.util.Date();
        return new Timestamp(date.getTime()).getTime();
    }

    public static long getTimeSince(long time) {
        return getUnixTime() - time;
    }

}
