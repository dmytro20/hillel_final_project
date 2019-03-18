package com.hillel.tour.agency.api.validator;

public interface Validator<Dto> {
    void validate(Dto entity);
}
