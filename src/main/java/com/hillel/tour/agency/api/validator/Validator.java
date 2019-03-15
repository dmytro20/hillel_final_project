package com.hillel.tour.agency.api.validator;

public interface Validator<T,ID> {
    T validator(ID id);
}
