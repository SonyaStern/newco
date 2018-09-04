package com.andreitop.newco.repository;

import com.andreitop.newco.dto.Dto;
import com.andreitop.newco.error.TripNotFoundExc;

import java.util.List;

public interface Repository<T extends Dto> {
    List<T> findAll();

    T findById(final Long id) throws TripNotFoundExc;

    void save(final T trip);

    void delete(final Long id) throws TripNotFoundExc;

    void update(final T newTrip) throws TripNotFoundExc;
}
