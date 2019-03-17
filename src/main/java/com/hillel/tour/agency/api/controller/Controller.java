package com.hillel.tour.agency.api.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Controller<T, ID> {

    ResponseEntity<T> get(ID id);

    ResponseEntity<T> post(T dto);

    ResponseEntity<T> update(T dto);

    ResponseEntity<T> delete(ID id);

    ResponseEntity<List<T>> getAll();

}
