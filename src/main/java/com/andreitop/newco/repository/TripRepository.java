package com.andreitop.newco.repository;

import com.andreitop.newco.dto.TripDto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;;

@Repository
public interface TripRepository extends JpaRepository<TripDto, Long> {}
