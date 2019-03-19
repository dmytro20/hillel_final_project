package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.Order;
import com.hillel.tour.agency.api.repository.postgre.OrdersPostgreRepository;
import com.hillel.tour.agency.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrdersPostgreRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrdersPostgreRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
