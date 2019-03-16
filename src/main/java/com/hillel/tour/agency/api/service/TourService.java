package com.hillel.tour.agency.api.service;

import com.hillel.tour.agency.api.entity.Tour;

import java.util.List;

public interface TourService {

    Tour getTourById(Integer id);

    List<Tour> getAllTours();
}
