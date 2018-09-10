package com.andreitop.newco.controller;

import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.repository.TripRepository;
import com.andreitop.newco.service.TripService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    TripService tripService;

    private TripDto tripDto;

    @Before
    public void setUp() {
        tripService = new TripService(tripRepository);
        tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setDestination("VKO");
        tripDto.setOrigin("LED");
        tripDto.setPrice(10000);
    }

    @Test
    public void tripRepositoryMethodsTest() {
        tripRepository.findAll();
        tripRepository.findById(1L);

    }

    @Test
    public void tripServiceMethodsTest() {
        tripService.save(tripDto);
        tripService.findAll();
        tripService.findById(1L);

        tripDto.setPrice(4526);
        tripService.update(tripDto);

        tripService.delete(1L);
    }
}
