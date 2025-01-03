package com.scaler.BookMyShow.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre extends BaseModel {

    private String theatreName;
    private String theatreAddress;

    @ManyToOne
    private City city;

    @OneToMany
    private List<Auditorium> auditoriums;
}
