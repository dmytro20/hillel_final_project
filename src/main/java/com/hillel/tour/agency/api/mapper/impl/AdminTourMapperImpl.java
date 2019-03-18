package com.hillel.tour.agency.api.mapper.impl;

import com.hillel.tour.agency.api.dto.AdminTourDto;
import com.hillel.tour.agency.api.entity.Tour;
import com.hillel.tour.agency.api.mapper.Mapper;

public class AdminTourMapperImpl
    implements Mapper<AdminTourDto, Tour>
{
    @Override
    public Tour mapToEntity(AdminTourDto adminTourDto)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public AdminTourDto mapToDto(Tour tour)
    {
        return new AdminTourDto(tour.getGuid().toString(),
                                tour.getName(),
                                tour.getCountry(),
                                tour.getType().toJsonValue(),
                                tour.getRating(),
                                tour.getComment(),
                                tour.getStatus().toString());
    }
}
