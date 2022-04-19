package com.wgutierrez.logger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchLog {
    private String IdLog;
    private String Hostname;
    private String Application;
    private String DateRange;
    private String NumberRows;
    private String Like;
    private String NotLike;

    public List<String> splitString(String values){
        return Arrays.asList(values.split(","));
    }

    public List<Date> splitDates(String values) {
        List<Date> dates = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (String date : values.split("-")) {
            String test2 = date.trim();
            LocalDate dateTime = LocalDate.parse(test2, formatter);
            dates.add(Date.valueOf(dateTime));
        }

        return dates;
    }
}
