package com.hillel.tour.agency.api.repository.postgre;

import com.hillel.tour.agency.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersPostgreRepository extends JpaRepository<Order,String> {
}
