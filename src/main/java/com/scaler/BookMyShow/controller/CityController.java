package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.model.City;
import com.scaler.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {

    CityService cityService;
    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    public City saveCity(City city) {
        return cityService.addCity(city);
    }

}
