package com.jb.couponsystemp2.utils;

import java.sql.Date;
import java.time.LocalDate;

public class DateUtil {

    public static String beautifyDate(Date date) {
        LocalDate localDate = date.toLocalDate();
        int day = localDate.getDayOfMonth();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();

        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
