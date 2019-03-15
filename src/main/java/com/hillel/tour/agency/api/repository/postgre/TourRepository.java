package com.hillel.tour.agency.api.repository.postgre;

import com.hillel.tour.agency.api.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TourRepository extends JpaRepository<Tour, UUID> {

}
