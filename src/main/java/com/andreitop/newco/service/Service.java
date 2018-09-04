package com.andreitop.newco.service;

import com.andreitop.newco.dto.Dto;
import com.andreitop.newco.error.TripNotFoundExc;
import com.andreitop.newco.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface Service<T extends Dto, U extends Repository> {
    List<T> findAll();

    T findById(Long id) throws TripNotFoundExc;

    void save(T trip);

    void delete(Long id) throws TripNotFoundExc;

    void update(T newTrip) throws TripNotFoundExc;
}
