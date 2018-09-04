package com.andreitop.newco.service;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripService<T extends TripDto, U extends TripRepository> implements Service<T, U> {

    private final U tripRepository;

    @Autowired
    public TripService(U tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<T> findAll() {
        return tripRepository.findAll();
    }

    public T findById(Long id) throws TripNotFoundExc {
        return (T) tripRepository.findById(id);
    }

    public void save(T trip) {
        tripRepository.save(trip);
    }

    public void delete(Long id) throws TripNotFoundExc {
        tripRepository.delete(id);
    }

    public void update(T newTrip) throws TripNotFoundExc {
        tripRepository.update(newTrip);
    }
}
