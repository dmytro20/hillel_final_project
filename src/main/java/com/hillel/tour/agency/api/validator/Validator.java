package com.hillel.tour.agency.api.validator;

public interface Validator<Dto> {
    Dto validator(Dto entity);
}
