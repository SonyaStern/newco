package com.andreitop.newco.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TripDto implements Dto {

    interface New {}

    interface Exist {}

    interface Update extends Exist{}

    @NotNull(groups = {Update.class})
    private Long id;

    @Length(min = 3, max = 30)
    @NotNull(groups = {New.class, Update.class})
    private String origin;

    @Length(min = 3, max = 30)
    @NotNull(groups = {New.class, Update.class})
    private String destination;

    @Size(min = 1, max = 1000000)
    @NotNull(groups = {New.class, Update.class})
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

