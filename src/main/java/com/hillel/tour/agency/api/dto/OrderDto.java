package com.hillel.tour.agency.api.dto;

import com.hillel.tour.agency.api.entity.Order;

import java.io.Serializable;
import java.util.Objects;

public final class OrderDto implements Serializable
{
    private final Integer id;
    private final String status;
    private final String date;
    private final Integer id_tour;
    private final Integer id_user;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.status = order.getStatus();
        this.date = order.getDate();
        this.id_tour = order.getId_tour();
        this.id_user = order.getId_user();
    }

    public OrderDto(Integer id, String status, String date, Integer id_tour, Integer id_user) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.id_tour = id_tour;
        this.id_user = id_user;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public Integer getId_tour() {
        return id_tour;
    }

    public Integer getId_user() {
        return id_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(id, orderDto.id) && Objects.equals(status, orderDto.status) && Objects.equals(date, orderDto.date) && Objects.equals(id_tour, orderDto.id_tour) && Objects.equals(id_user, orderDto.id_user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, status, date, id_tour, id_user);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderDto{");
        sb.append("id=").append(id);
        sb.append(", status='").append(status).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", id_tour=").append(id_tour);
        sb.append(", id_user=").append(id_user);
        sb.append('}');
        return sb.toString();
    }
}
