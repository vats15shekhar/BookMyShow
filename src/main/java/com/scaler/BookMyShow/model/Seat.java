package com.scaler.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{

    private int row;
    private int col;
    private String seatNumber;

    @Enumerated(EnumType.STRING) // Create a table for the Enum SeatType
    private SeatType seatType;

    @Enumerated(EnumType.STRING) // Create a table for the Enum seatStatus
    private SeatStatus seatStatus;

    @ManyToOne
    private Auditorium auditorium;
}
