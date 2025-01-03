package com.scaler.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{

    private double totalAmount;
    private Date TimeOfBooking;

    @ManyToOne
    private Show show;

    @OneToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private User bookedBy;

    @OneToOne
    private Payment payment;

}
