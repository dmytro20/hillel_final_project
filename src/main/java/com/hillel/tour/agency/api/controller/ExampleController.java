package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController
{
    private ExampleService exampleService;

    @Autowired
    public ExampleController(ExampleService exampleService)
    {
        this.exampleService = exampleService;
    }

    @GetMapping("/{exampleId}")
    public String getExamplesString(@PathVariable String exampleId){
        return exampleService.getTestString() + " Id " + exampleId;
    }

    @GetMapping("/{exampleId}/address/{addressId}")
    public String getExampleAddressString(@PathVariable String exampleId, @PathVariable String addressId){
        return exampleService.getTestString() + " Id: " + exampleId + "; Address Id: " + addressId;
    }

    @PutMapping
    public String updateExampleString(){
        return "stub";
    }

    @PostMapping
    public String createExampleString(){
        return "stub";
    }

    @DeleteMapping
    public void deleteExampleString(){
    }


}
