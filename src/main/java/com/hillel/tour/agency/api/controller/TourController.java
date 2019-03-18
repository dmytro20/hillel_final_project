package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.dto.AdminTourDto;
import com.hillel.tour.agency.api.dto.TourCreationDto;
import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.mapper.impl.AdminTourMapperImpl;
import com.hillel.tour.agency.api.mapper.impl.TourCreatedMapperImpl;
import com.hillel.tour.agency.api.service.TourService;
import com.hillel.tour.agency.api.validator.Validator;
import com.hillel.tour.agency.api.validator.impl.TourValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

    @PostMapping
    public ResponseEntity<AdminTourDto> createTour(@RequestBody TourCreationDto tourDto)
    {
        Validator validator = new TourValidator();
        validator.validate(tourDto);

        Tour tour = new TourCreatedMapperImpl().mapToEntity(tourDto);

        Optional<Tour> createdTour = tourService.addTour(tour);

        if (createdTour.isPresent())
        {
            return ResponseEntity.status(201).body(new AdminTourMapperImpl().mapToDto(createdTour.get()));
        }

        return ResponseEntity.badRequest().build();

    }
}
