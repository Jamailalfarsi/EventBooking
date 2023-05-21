package com.example.demo.Repository;
import com.example.demo.Models.Event;
import com.example.demo.Models.TicketBooking;
import com.example.demo.Models.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
    @Query(value = "SELECT id FROM event  WHERE name = :name", nativeQuery = true)
    Integer findIdByEventName(@Param("name") String name);

    @Query (value = "SELECT s from Event s where s.name= :name" )
    Event getByEventName(@Param("name")String name);
    @Query(value = "SELECT s from Event s")
    List<Event> getAllEvents();
    @Query (value = "SELECT s from Event s where s.id = :id")
    Event getBEventById(@Param("id")Integer id);




}
