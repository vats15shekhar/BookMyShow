package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.exception.ShowSeatNotAvailable;
import com.scaler.BookMyShow.model.Ticket;
import com.scaler.BookMyShow.model.User;
import com.scaler.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

    TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /*
     It is always a good idea to handle the exception either in the top most layer (Controller)
     or the bottommost layer (Service). It is not a good practice to handle an exception
     anywhere in the interacting layers in between
     */

    public Ticket bookTicket(Long showId, List<Long> showSeatsId, User user) throws ShowSeatNotAvailable {
      return  ticketService.bookTicket(showId, showSeatsId, user);
    }

}
