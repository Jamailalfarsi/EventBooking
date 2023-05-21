package com.example.demo.Repository;

import com.example.demo.Models.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer> {

    @Query(value = "SELECT s from TicketBooking s")
    List<TicketBooking> getAllBookings();

    @Query (value = "SELECT s from TicketBooking s where s.id = :id")
    TicketBooking getBookingById(@Param("id")Integer id);

//    @Query (value = "SELECT s.id from TicketBooking s where s.name = :name")
//    Integer generateIdByName(@Param("name")String name);




}
