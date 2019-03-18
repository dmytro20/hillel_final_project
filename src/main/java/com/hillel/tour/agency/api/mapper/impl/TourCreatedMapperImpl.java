package com.hillel.tour.agency.api.mapper.impl;

import com.hillel.tour.agency.api.dto.TourCreationDto;
import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.entity.TourStatus;
import com.hillel.tour.agency.api.entity.TourType;
import com.hillel.tour.agency.api.mapper.Mapper;

import java.util.UUID;

public class TourCreatedMapperImpl
    implements Mapper<TourCreationDto, Tour> {
    @Override
    public Tour mapToEntity(TourCreationDto entity) {
        return new Tour().setGuid(UUID.randomUUID())
                .setName(entity.getName())
                .setCountry(entity.getCountry())
                .setComment(entity.getComment())
                .setRating(entity.getRating())
                .setType(TourType.fromString(entity.getType()))
            .setStatus(TourStatus.ACTIVE);

    }

    @Override
    public TourCreationDto mapToDto(Tour tour)
    {
        throw new UnsupportedOperationException();
    }
}
