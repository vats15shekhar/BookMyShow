package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.model.City;
import com.scaler.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    CityRepository CityRepository;
    @Autowired
    public CityService(CityRepository cityRepository) {
        this.CityRepository = cityRepository;
    }

    public City addCity(City city) {
        return CityRepository.save(city);
    }

}
