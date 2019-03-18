package com.hillel.tour.agency.api.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TourType
{
    REST("rest"), EXCURSION("excursion"), SPA("spa");

    private String value;

    private TourType(String value)
    {
        this.value = value;
    }

    public static TourType fromString(String value){
        return TourType.valueOf(value.toUpperCase());
    }

    public String toJsonValue(){
        return value;
    }
}
