package ru.skillup.youthtourism.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class JdbcHelper {

    public static Integer getInteger(ResultSet rs, String columnName) throws SQLException {
        int result = rs.getInt(columnName);
        return rs.wasNull() ? null : result;
    }

    public static Double getDouble(ResultSet rs, String columnName) throws SQLException {
        double result = rs.getDouble(columnName);
        return rs.wasNull() ? null : result;
    }

    public static Long getLong(ResultSet rs, String columnName) throws SQLException {
        long result = rs.getLong(columnName);
        return rs.wasNull() ? null : result;
    }

    public static Boolean getBoolean(ResultSet rs, String columnName) throws SQLException {
        boolean result = rs.getBoolean(columnName);
        return rs.wasNull() ? null : result;
    }

    public static String getString(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        return rs.wasNull() ? null : result;
    }

    public static LocalDate getLocalDate(ResultSet rs, String columnName) throws SQLException {
        return Optional.ofNullable(rs.getTimestamp(columnName))
                .map(Timestamp::toLocalDateTime)
                .map(LocalDateTime::toLocalDate)
                .orElse(null);
    }

    public static <T> T getEnumValue(ResultSet rs, String columnName, T[] enumItems) throws SQLException {
        String result = rs.getString(columnName);
        if (!rs.wasNull()) {
            for (T item : enumItems) {
                if (item.toString().equals(result)) {
                    return item;
                }
            }
            throw new IllegalArgumentException("enum type has no constant " + result);
        }
        return null;
    }
}
