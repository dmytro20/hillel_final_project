package com.hillel.tour.agency.api.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private String date;

    @Column(name = "id_tour")
    private Integer id_tour;

    @Column(name = "id_user")
    private Integer id_user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_tour() {
        return id_tour;
    }

    public void setId_tour(Integer id_tour) {
        this.id_tour = id_tour;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return  Objects.equals(id, order.id) &&
                Objects.equals(status, order.status) &&
                Objects.equals(date, order.date) &&
                Objects.equals(id_tour, order.id_tour) &&
                Objects.equals(id_user, order.id_user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getStatus(), getDate(), getId_tour(), getId_user());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", status='").append(status).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", id_tour=").append(id_tour);
        sb.append(", id_user=").append(id_user);
        sb.append('}');
        return sb.toString();
    }
}
