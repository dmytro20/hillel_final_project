package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class TourServiceImpl implements TourService {

    @Autowired
    public TourServiceImpl() {
    }

    @Override
    @RequestMapping(value = "/tourId{tourId}")
    public Tour getTourById(@PathVariable("tourId") String tourId) {
        return new Tour();
    }
}
