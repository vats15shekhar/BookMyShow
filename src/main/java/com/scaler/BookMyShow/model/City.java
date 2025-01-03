package com.scaler.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{

    private String cityName;
    private String address;

    @OneToMany
    private List<Theatre> theatres;

}
