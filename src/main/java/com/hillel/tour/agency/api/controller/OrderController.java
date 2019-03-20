package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.dto.OrderDto;
import com.hillel.tour.agency.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/orders")
public class OrderController extends Controller
{
    @Autowired
    private OrderService orderService;

    @GetMapping("/id")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Integer id, HttpServletRequest request)
    {
        auth(request);

        OrderDto orderDto = new OrderDto(orderService.get(id));
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }
}
