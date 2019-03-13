package com.hillel.tour.agency.api.repository.postgre;

import com.hillel.tour.agency.api.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Integer>
{
}
