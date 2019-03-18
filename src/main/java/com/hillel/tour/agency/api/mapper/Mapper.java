package com.hillel.tour.agency.api.mapper;

public interface Mapper<DTOType, EntityType>
{
    EntityType mapToEntity(DTOType dto);
    DTOType mapToDTO(EntityType entity);
}
