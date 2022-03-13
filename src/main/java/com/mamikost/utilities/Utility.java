package com.mamikost.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author regiewby on 13/03/22
 * @project technical-test-mamikost
 */
public class Utility {

    public String getDateTime(String timePattern, String timeCondition) {

        String result = "";

        if (timeCondition.equalsIgnoreCase("today")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timePattern);
            LocalDate now = LocalDate.now();
            result = dtf.format(now);

        } else if (timeCondition.equalsIgnoreCase("tomorrow")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timePattern);
            LocalDate now = LocalDate.now();
            LocalDate tomorrow = now.plusDays(1);
            result = dtf.format(tomorrow);

        } else if (timeCondition.equalsIgnoreCase("next week")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(timePattern);
            LocalDate now = LocalDate.now();
            LocalDate tomorrow = now.plusDays(7);
            result = dtf.format(tomorrow);
        }
        return result;
    }
}
