package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.repository.postgre.TourRepository;
import com.hillel.tour.agency.api.service.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl
    implements TourService
{
    private static final Logger LOG = LoggerFactory.getLogger(TourServiceImpl.class);

    private TourRepository tourRepository;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository)
    {
        this.tourRepository = tourRepository;
    }

    @Override
    public Tour getTourById(Integer id)
    {
        LOG.info("Find tour by id: {}", id);

        return tourRepository.findOne(id);
    }

    @Override
    public List<Tour> getAllTours()
    {
        LOG.info("Find all tours");

        return tourRepository.findAll();
    }
}
