package com.hillel.tour.agency.api.Mapper;

public interface Mapper<FROM, TO>
{
    TO map(FROM from);
}
