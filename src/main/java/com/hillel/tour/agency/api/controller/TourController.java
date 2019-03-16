package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tours")
public class TourController
{

    private TourService tourService;

    @Autowired
    public TourController(TourService tourService)
    {
        this.tourService = tourService;
    }

    @GetMapping
    public ResponseEntity<List<Tour>> getTours()
    {
        return ResponseEntity.status(200).body(tourService.getAllTours());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Integer id)
    {
        if (id == null)
        {
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(tourService.getTourById(id));
    }
}
