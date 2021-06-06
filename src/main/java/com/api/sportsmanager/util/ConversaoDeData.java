package com.api.sportsmanager.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ConversaoDeData {

    public static Timestamp localDateTimeToTimestamp(LocalDateTime data) {
        return Timestamp.valueOf(data);
    }

    public static LocalDateTime timestampToLocalDateTime(Timestamp data) {
        return data.toLocalDateTime();
    }
}