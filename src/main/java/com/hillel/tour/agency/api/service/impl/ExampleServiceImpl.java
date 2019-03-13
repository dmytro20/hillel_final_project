package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.Example;
import com.hillel.tour.agency.api.repository.postgre.ExampleRepository;
import com.hillel.tour.agency.api.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExampleServiceImpl
    implements ExampleService
{
    private ExampleRepository repository;
    //private OrderRepository _orderRepository;

    @Autowired
    public ExampleServiceImpl(ExampleRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public String getTestString()
    {
        Example existsEntity = repository.findOne(1);
        //existsEntity change
        repository.save(existsEntity);


        repository.findAll();

        //return repository.find();
        return "Service layer!!!";
    }

    @Transactional
    public String getOrderByExample(Integer exampleId){
        Example existsEntity = repository.findOne(exampleId);
        //return _orderRepository.findOne(existsEntity.getOrderId());
        return "sds";
    }
}
