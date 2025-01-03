package com.scaler.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity

public class ShowSeat extends BaseModel{

    private int price;

    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Show show;

    @Enumerated (EnumType.STRING )
    private ShowSeatStatus showSeatStatus;

    @ManyToOne
    private Ticket ticket;

}

/*
ShowSeat : Ticket -> M:1
 */
