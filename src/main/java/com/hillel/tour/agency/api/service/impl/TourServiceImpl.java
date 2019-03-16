package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.repository.postgre.TourRepository;
import com.hillel.tour.agency.api.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public Tour getTourById(Integer id) {
        return tourRepository.findOne(id);

    }
}
