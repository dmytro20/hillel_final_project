package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    private ExampleService exampleService;

    @Autowired
    public ExampleController(@Qualifier("exampleServiceImpl") ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/example/{exampleId}")
    public String getExamplesString(@PathVariable String exampleId) {
        return exampleService.getTestString() + " Id " + exampleId;
    }

    @GetMapping("/examples/{exampleId}/address/{addressId}")
    public String getExampleAddressString(@PathVariable String exampleId, @PathVariable String addressId) {
        return exampleService.getTestString() + " Id: " + exampleId + "; Address Id: " + addressId;
    }

    @PutMapping("/example")
    public String updateExampleString() {
        return "stub";
    }

    @PostMapping("/example")
    public String createExampleString() {
        return "stub";
    }

    @DeleteMapping("/example")
    public void deleteExampleString() {
    }


}
