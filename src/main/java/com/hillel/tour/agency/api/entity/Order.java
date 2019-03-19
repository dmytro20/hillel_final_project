package com.hillel.tour.agency.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order
{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "guid", unique = true)
    private UUID guid;

    @Column(name = "status")
    private String status;

    @Column(name = "date")
    private String date;

    @Column(name = "id_tour")
    private Integer tourId;

    @Column(name = "id_user")
    private Integer userId;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public UUID  getGuid()
    {
        return guid;
    }

    public void setGuid(UUID guid)
    {
        this.guid = guid;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public Integer getTourId()
    {
        return tourId;
    }

    public void setTourId(Integer tourId)
    {
        this.tourId = tourId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
               Objects.equals(guid, order.guid) &&
               Objects.equals(status, order.status) &&
               Objects.equals(date, order.date) &&
               Objects.equals(tourId, order.tourId) &&
               Objects.equals(userId, order.userId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, guid, status, date, tourId, userId);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", guid='").append(guid).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", tourId=").append(tourId);
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
