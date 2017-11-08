package com.presentie.administratie.registrationservice.receivers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.presentie.administratie.registrationservice.controllers.StatusController;
import com.presentie.administratie.registrationservice.models.Status;
import com.presentie.administratie.registrationservice.models.StatusTimeModel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


@RabbitListener(queues = "status")
public class StatusReceiver {

    @Autowired
    ObjectMapper mapper;

    @RabbitHandler
    public void receive(String statusAsJSON) throws IOException, ParseException {

        StatusTimeModel model = mapper.readValue(statusAsJSON, StatusTimeModel.class);

        LocalDate date = LocalDate.parse(model.getDate().replaceAll("\\D", "."), DateTimeFormatter.ofLocalizedDate(
                FormatStyle.MEDIUM).withLocale(Locale.GERMAN));

        Status status = new Status(model.getName(), model.isPresent(), date);
        StatusController.statusList.add(status);
        System.out.println();

    }
}
