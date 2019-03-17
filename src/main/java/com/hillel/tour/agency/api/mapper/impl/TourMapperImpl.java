package com.hillel.tour.agency.api.mapper.impl;

import com.hillel.tour.agency.api.dto.impl.TourDtoImpl;
import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.mapper.Mapper;

public class TourMapperImpl implements Mapper<TourDtoImpl, Tour> {
    @Override
    public Tour mapToEntity(TourDtoImpl entity) {
        return new Tour().setId(entity.getId())
                .setName(entity.getName())
                .setCountry(entity.getCountry())
                .setComment(entity.getComment())
                .setRating(entity.getRating())
                .setStatus(entity.getStatus())
                .setType(entity.getType());
    }

}
