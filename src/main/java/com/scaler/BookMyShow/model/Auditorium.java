package com.scaler.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{

    private String name;

    @OneToMany
    private List<Seat> seats;

    @ManyToOne
    private Theatre theatre;

    @ElementCollection // This will ensure M:M mapping with ENUM. Feature is an ENUM
    @Enumerated(EnumType.STRING) // This will create a table for the ENUM
    private List<Feature> features;


}

/*
    Auditorium : Features -> M:M
    Auditorium : Theatre -> M:1
    Auditorium : Seats -> 1:M
 */
