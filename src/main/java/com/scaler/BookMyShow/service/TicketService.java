package com.scaler.BookMyShow.service;

import com.scaler.BookMyShow.exception.ShowSeatNotAvailable;
import com.scaler.BookMyShow.model.*;
import com.scaler.BookMyShow.repository.ShowRepository;
import com.scaler.BookMyShow.repository.ShowSeatRepository;
import com.scaler.BookMyShow.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class TicketService {

    TicketRepository ticketRepository;
    ShowSeatRepository showSeatRepository;
    ShowRepository showRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ShowSeatRepository showSeatRepository, ShowRepository showRepository) {
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
    }

    /*
     @Transactional(isolation = Isolation.SERIALIZABLE)

     This annotation will ensure that as soon as this method is called for a user who is trying to book tickets
     the method will wait for the whole transcation inside it to be completed before it allows
     any other call. Only once the whole transaction is completed - Either commited or rolled back, any other
     users call will be executed.
     */
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long showId, List<Long> showSeatsId, User user) throws ShowSeatNotAvailable {
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatsId);

        // Check for all the available seats
        for(ShowSeat showSeat : showSeats)
        {
            // Check if one of the seats is not available from the list of seats that is requested
            // by the user
            if(! showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE))
            {
                throw new ShowSeatNotAvailable("Show Seat is not available");
            }
        }

        // If the above logic does not throw an exception, it means that all the
        // show seats selected by the user is available. We must Lock it for the user, so
        // that anyone else cannot book the same seat while this user is making his payment
        for(ShowSeat showSeat : showSeats)
        {
            // Now the show seats that are selected by the user will be updated
            // in the database table ShowSeat with ShowSeatStatus as LOCKED
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            // This line will update the table showSeat
            showSeatRepository.save(showSeat);
        }

        //wait for payment confirmation
        //assuming payment is done
        // create and return the ticket object

        Ticket t =new Ticket();
        t.setShowSeats(showSeats);
        t.setShow(showRepository.findById(showId).get());
        t.setBookedBy(user);

        // Save these the details in the t object and return the object
        ticketRepository.save(t);

        for(ShowSeat showSeat : showSeats)
        {
            // Now change the status of those seats to booked
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
            // This line will update the table showSeat
            showSeatRepository.save(showSeat);
        }
    // return this ticket to the UI
     return t;
    }

}
