package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TourController<T, I>
{
    private TourService tourService;
    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping("/tour")
    public String createTourString(){
        return "stub";
    }
}
