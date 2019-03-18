package com.hillel.tour.agency.api.service;

import com.hillel.tour.agency.api.entity.Tour;

import java.util.Optional;

public interface TourService
{
    Optional<Tour> addTour(Tour tour);
}
