package com.hillel.tour.agency.api.mapper;

public interface Mapper<From, To> {
    To mapToEntity(From dto);
    From mapToDto (To entity);
}
