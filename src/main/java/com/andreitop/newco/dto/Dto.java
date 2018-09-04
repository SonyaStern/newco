package com.andreitop.newco.dto;

import java.io.Serializable;

public interface Dto extends Serializable {
    long serialVersionUID = 5914366185889783660L;

    Long getId();

    void setId(Long id);

    String getOrigin();

    void setOrigin(String origin);

    String getDestination();

    void setDestination(String destination);

    Integer getPrice();

    void setPrice(Integer price);
}
