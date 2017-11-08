package com.presentie.administratie.registrationservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Status  {
    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private boolean present;
    @JsonProperty
    private LocalDate date;

    public Status(String name, boolean present, LocalDate date) {
        this.name = name;
        this.present = present;
        this.date = date;
    }

}
