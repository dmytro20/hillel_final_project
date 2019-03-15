package com.hillel.tour.agency.api.dto.impl;

import com.hillel.tour.agency.api.dto.EntityDto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

public class TourDtoImpl implements EntityDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Size(min = 2,max = 50)
    private String name;
    @Size(min = 2,max = 50)
    private String contry;
    @Size(min = 2,max = 50)
    private String status;
    @Size(min = 2,max = 50)
    private String type;
    @Size(min = 2,max = 50)
    private String rating;
    @Size(min = 2,max = 50)
    private String comment;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourDtoImpl tourDto = (TourDtoImpl) o;
        return Objects.equals(id, tourDto.id) &&
                Objects.equals(name, tourDto.name) &&
                Objects.equals(contry, tourDto.contry) &&
                Objects.equals(status, tourDto.status) &&
                Objects.equals(type, tourDto.type) &&
                Objects.equals(rating, tourDto.rating) &&
                Objects.equals(comment, tourDto.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contry, status, type, rating, comment);
    }

    @Override
    public String toString() {
        return "TourDtoImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contry='" + contry + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", rating='" + rating + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
