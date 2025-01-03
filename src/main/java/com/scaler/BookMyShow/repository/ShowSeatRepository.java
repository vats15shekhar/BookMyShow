package com.scaler.BookMyShow.repository;

import com.scaler.BookMyShow.model.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    /*
    The Pessimistic Lock will prevent any other user from even reading the show seats.
    The Book My show app will show loading, if any other user is trying to open the seat booking page
    This process is relatively fast so the loading page will show only for a second or so
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE) //putting pessimistic lock on the below query
    List<ShowSeat> findByIdIn(List<Long> showSeatIds); // select * from showSeat where id in (...);
    ShowSeat save(ShowSeat seat); // insert new record and update an existing record

    List<ShowSeat> findAllById(List<Long> showSeatsId);
}
