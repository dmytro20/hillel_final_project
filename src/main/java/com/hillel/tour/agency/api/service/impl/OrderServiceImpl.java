package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.Order;
import com.hillel.tour.agency.api.repository.postgre.OrderRepository;
import com.hillel.tour.agency.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService
{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order get(Integer integer) {
        return null;
    }

    @Override
    public Order save(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
