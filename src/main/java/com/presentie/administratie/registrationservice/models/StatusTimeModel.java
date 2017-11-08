package com.presentie.administratie.registrationservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatusTimeModel {

    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private boolean present;
    @JsonProperty(required = true)
    private String date;
}
