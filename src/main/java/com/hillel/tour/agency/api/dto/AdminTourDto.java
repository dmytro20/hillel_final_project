package com.hillel.tour.agency.api.dto;

import java.util.Objects;

public class AdminTourDto
{
    private final String guid;

    private final String name;

    private final String country;

    private final String type;

    private final String rating;

    private final String comment;

    private final String status;

    public AdminTourDto(String guid, String name, String country, String type, String rating, String comment,
                        String status)
    {
        this.guid = guid;
        this.name = name;
        this.country = country;
        this.type = type;
        this.rating = rating;
        this.comment = comment;
        this.status = status;
    }

    public String getGuid()
    {
        return guid;
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

    public String getStatus()
    {
        return status;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AdminTourDto that = (AdminTourDto) o;
        return Objects.equals(guid, that.guid) &&
               Objects.equals(name, that.name) &&
               Objects.equals(country, that.country) &&
               Objects.equals(type, that.type) &&
               Objects.equals(rating, that.rating) &&
               Objects.equals(comment, that.comment) &&
               Objects.equals(status, that.status);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(guid, name, country, type, rating, comment, status);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AdminTourDto{");
        sb.append("guid='").append(guid).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", rating='").append(rating).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
