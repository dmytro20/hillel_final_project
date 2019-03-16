package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.service.TourService;
import com.hillel.tour.agency.api.service.impl.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/tours")
public class TourController {

    private TourService tourService;

    @Autowired
    public  TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public String getTours() {
        return "Stab";
    }

    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable Integer id){
        return tourService.getTourById(id);
    }
}
