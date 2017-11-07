package com.presentie.administratie.registrationservice.controllers;


import com.presentie.administratie.registrationservice.models.Status;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    public static List<Status> statusList = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET)
    public List<Status> getStatusList(){
        return statusList;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void addStatusToList(@RequestBody Status status){
        statusList.add(status);


    }

    @RequestMapping(path = "/test")
    public void test(){
        Status status = new Status("Rico", true);

        RestTemplate build = new RestTemplateBuilder().build();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<Status> entity = new HttpEntity<>(status, headers);

        Status status1 = build.postForObject("http://localhost:8001/api/status/add", entity, Status.class);
    }

}
