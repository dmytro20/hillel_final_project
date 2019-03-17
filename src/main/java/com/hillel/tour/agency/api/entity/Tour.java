package com.hillel.tour.agency.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Table;

@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String country;
    private String status;
    private String type;
    private String rating;
    private String comment;

    public Tour setId(UUID id) {
        this.id = id;
        return this;
    }

    public Tour setName(String name) {
        this.name = name;
        return this;
    }

    public Tour setCountry(String country) {
        this.country = country;
        return this;
    }

    public Tour setStatus(String status) {
        this.status = status;
        return this;
    }

    public Tour setType(String type) {
        this.type = type;
        return this;
    }

    public Tour setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public Tour setComment(String comment) {
        this.comment = comment;
        return this;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "idTour=" + id +
                ", name='" + name + '\'' +
                ", contry='" + country + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", rating='" + rating + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) &&
                Objects.equals(name, tour.name) &&
                Objects.equals(country, tour.country) &&
                Objects.equals(status, tour.status) &&
                Objects.equals(type, tour.type) &&
                Objects.equals(rating, tour.rating) &&
                Objects.equals(comment, tour.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, status, type, rating, comment);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

}
