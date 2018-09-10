package com.andreitop.newco.controller;

import com.andreitop.newco.common.ApiConstant;
import com.andreitop.newco.dto.TripDto;
import com.andreitop.newco.error.TripNotFoundExc;
import com.andreitop.newco.repository.TripRepository;
import com.andreitop.newco.service.TripService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class TripsServiceTest {

    private static final String TRIP_JSON = "{\"origin\": \"LED\" , \"destination\":\"MOW\", \"price\" : 12256}";
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    private static final String API_URL = ApiConstant.API_V_1 + "/trips";
    private static final String API_URL_ID = ApiConstant.API_V_1 + "/trips/{id}";
    
    @MockBean
    private TripRepository tripRepository;
    private TripService tripService;

    @Before
    public void setUp() {
        tripService = new TripService(tripRepository);
    }



    @Test
    public void saveTest() throws Exception {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);
        tripService.save(tripDto);
        verify(tripRepository, times(1)).save(tripDto);
    }



    @Test
    public void findAll() throws Exception {

        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        List<TripDto> allTrips = Collections.singletonList(tripDto);
        when(tripRepository.findAll()).thenReturn(allTrips);
        List<TripDto> actual = tripService.findAll();


        assertEquals(actual, allTrips);
    }

    @Test
    public void findByIdTest() throws TripNotFoundExc {

        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        when(tripRepository.findById(1L)).thenReturn(tripDto);
        TripDto actual = tripService.findById(1L);
        assertThat(actual, is(tripDto));
    }

    @Test
    public void updateTest() throws TripNotFoundExc {
        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        tripService.update(tripDto);
        verify(tripRepository, times(1)).update(tripDto);
    }

    @Test
    public void deleteTest() throws TripNotFoundExc {

        TripDto tripDto = new TripDto();
        tripDto.setId(1L);
        tripDto.setOrigin("MOW");
        tripDto.setDestination("LED");
        tripDto.setPrice(4232);

        tripService.delete(1L);
        verify(tripRepository, times(1)).delete(1L);

    }

}
