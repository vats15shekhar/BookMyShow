package com.scaler.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{

    private String name;

    @OneToMany
    private List<Show> shows;

    @ManyToMany
    private List<Actor> actors;

    @ElementCollection // This will ensure M:M mapping with ENUM. Language is an ENUM
    @Enumerated(EnumType.STRING) // Converts Language ENUM into table
    private List<Language> languages;

    @ElementCollection // This will ensure M:M mapping with ENUM. Feature is an ENUM
    @Enumerated(EnumType.STRING) // Converts Feature ENUM into table
    private List<Feature> features;
}

/*
    Movie : Shows -> 1 : M
    Movie : Actors -> M : M
    Movie : Language -> M : M
    Movie : features -> M : M

 */
