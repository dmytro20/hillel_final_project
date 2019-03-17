package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.dto.impl.TourDtoImpl;
import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.mapper.impl.TourMapperImpl;
import com.hillel.tour.agency.api.service.TourService;
import com.hillel.tour.agency.api.validator.Validator;
import com.hillel.tour.agency.api.validator.impl.TourValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tours")
public class TourController
{
    private TourService tourService;
    @Autowired
    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping
    public ResponseEntity<Tour> createTour(TourDtoImpl tourDto){
        Validator validator = new TourValidator();
        validator.validator(tourDto);
        return ResponseEntity.status(201).body(tourService.addTour((new TourMapperImpl()).mapToEntity(tourDto)));
    }
}
