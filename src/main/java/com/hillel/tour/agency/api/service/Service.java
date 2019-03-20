package com.hillel.tour.agency.api.service;


import java.util.List;

public interface Service<T, ID>{
    T get(ID id);
    T save(T entity);
    T update(T entity);
    void delete(ID id);
    List<T> getAll();

}
