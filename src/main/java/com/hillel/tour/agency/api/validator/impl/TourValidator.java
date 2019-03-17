package com.hillel.tour.agency.api.validator.impl;

import com.hillel.tour.agency.api.dto.impl.TourDtoImpl;
import com.hillel.tour.agency.api.validator.Validator;

public class TourValidator implements Validator<TourDtoImpl> {
    @Override
    public TourDtoImpl validator(TourDtoImpl entity) {
        //validation
        return entity;
    }
}
