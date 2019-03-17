package com.hillel.tour.agency.api.mapper;

public interface Mapper<DTO,Entity> {
    Entity mapToEntity (DTO entity);
}
