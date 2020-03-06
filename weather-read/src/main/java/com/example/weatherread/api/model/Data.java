package com.example.weatherread.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@lombok.Data
public class Data {

    private int id;
    private Coordinates coord;
}
