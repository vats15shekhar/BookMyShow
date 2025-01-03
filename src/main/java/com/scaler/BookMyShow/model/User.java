package com.scaler.BookMyShow.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User extends BaseModel{

    private String mame;
    private long mobile;
    private String email;

}
