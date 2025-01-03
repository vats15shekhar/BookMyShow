package com.scaler.BookMyShow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Payment extends BaseModel{

    private double amount;
    private String transactionId;
    private Date timeStamp;

    @ManyToOne
    private Movie movie;

    @Enumerated (EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne
    private Ticket ticket;
}

/*
 Payment : PaymentStatus : -> M:1
 1 - Successful or failure or inprogress
 100 payments -> 95 successful, 3 failed, 2 in progress
 Successful -> P1, P2, P3
 Payment : Ticket -> 1:1
 */
