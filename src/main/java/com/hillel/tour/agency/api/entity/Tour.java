package com.hillel.tour.agency.api.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tour
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
