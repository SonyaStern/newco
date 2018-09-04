package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripDto;
import org.springframework.stereotype.Repository;
import com.andreitop.newco.error.NoTripsHandler;
import com.andreitop.newco.error.TripNotFoundExc;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TripRepository<T extends TripDto> implements Repository<T>{

    private final List<T> trips = new ArrayList<>();

    public List<T> findAll() {
        if (trips.size() > 0) {
            return trips;
        } else {
            throw new NoTripsHandler();
        }
    }

    public T findById(final Long id) throws TripNotFoundExc {
        return trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(TripNotFoundExc::new);
    }

    public void save(final T trip) {
        trip.setId((long) (trips.size() + 1));
        trips.add(trip);
    }

    public void delete(final Long id) throws TripNotFoundExc {
        trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(trips::remove)
                .orElseThrow(TripNotFoundExc::new);
    }

    public void update(final T newTrip) throws TripNotFoundExc {
        trips.stream()
                .filter(t -> t.getId().equals(newTrip.getId()))
                .findFirst()
                .map(t -> trips.set(trips.indexOf(t), newTrip))
                .orElseThrow(TripNotFoundExc::new);
    }
}
