package com.hillel.tour.agency.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String contry;
    private String status;
    private String type;
    private String rating;
    private String comment;

    @Override
    public String toString() {
        return "Tour{" +
                "idTour=" + id +
                ", name='" + name + '\'' +
                ", contry='" + contry + '\'' +
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
                Objects.equals(contry, tour.contry) &&
                Objects.equals(status, tour.status) &&
                Objects.equals(type, tour.type) &&
                Objects.equals(rating, tour.rating) &&
                Objects.equals(comment, tour.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contry, status, type, rating, comment);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID idTour) {
        this.id = idTour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
