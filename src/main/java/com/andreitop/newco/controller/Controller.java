package com.andreitop.newco.controller;

import com.andreitop.newco.dto.Dto;
import com.andreitop.newco.error.TripNotFoundExc;
import com.andreitop.newco.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface Controller<T extends Dto, S extends Service> {

    List<T> findAll();

    T findById(@PathVariable("id") final Long id) throws TripNotFoundExc;

    void create(@RequestBody final T trip);

    void delete(@PathVariable("id") final Long id) throws TripNotFoundExc;

    void update(@RequestBody final T newTrip) throws TripNotFoundExc;
}
