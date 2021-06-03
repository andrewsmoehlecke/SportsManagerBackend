package com.api.sportsmanager.util;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConversaoDeData {

    public static Date localDateTimeToDate(LocalDateTime data) {
        return Date.valueOf(data.toLocalDate());
    }
    
    public static LocalDateTime dateToLocalDateTime(Date data) {
        return data.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}