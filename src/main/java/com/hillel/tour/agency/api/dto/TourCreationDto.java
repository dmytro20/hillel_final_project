package com.hillel.tour.agency.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.util.Objects;

public class TourCreationDto
{
    @Size(min = 2, max = 50)
    @JsonProperty("name")
    private String name;

    @Size(min = 2, max = 50)
    @JsonProperty("country")
    private String country;

    @Size(min = 2, max = 50)
    @JsonProperty("type")
    private String type;

    @Size(min = 2, max = 50)
    @JsonProperty("rating")
    private String rating;

    @Size(min = 2, max = 50)
    @JsonProperty("comment")
    private String comment;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public String getName()
    {
        return name;
    }

    public String getCountry()
    {
        return country;
    }

    public String getType()
    {
        return type;
    }

    public String getRating()
    {
        return rating;
    }

    public String getComment()
    {
        return comment;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TourCreationDto tourDto = (TourCreationDto) o;
        return Objects.equals(name, tourDto.name) &&
               Objects.equals(country, tourDto.country) &&
               Objects.equals(type, tourDto.type) &&
               Objects.equals(rating, tourDto.rating) &&
               Objects.equals(comment, tourDto.comment);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, country, type, rating, comment);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("TourCreationDto{");
        sb.append(", name='").append(name).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", rating='").append(rating).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
