package com.example.demo.Service;

import com.example.demo.Models.Event;
import com.example.demo.Models.TicketBooking;
import com.example.demo.Models.UserRegistration;
import com.example.demo.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public void addEventData( String name,String dateFrom,String dateTo,Integer numberOfDate, String time,
                              String location,Double price,Integer ticketAvailable,
                              String createdDate,String updatedDate,Boolean isActive ) {
        Event event=new Event();
        event.setName(name);
        event.setDateFrom(dateFrom);
        event.setDateTo(dateTo);
        event.setNumberOfDate(numberOfDate);
        event.setTime(time);
        event.setLocation(location);
        event.setPrice(price);
        event.setTicketAvailable(ticketAvailable);
        event.setCreatedDate(createdDate);
        event.setUpdatedDate(updatedDate);
        event.setIsActive(isActive);
        eventRepository.save(event);


    }
    public Event getByEventName( String name){
        return eventRepository.getByEventName(name);


    }
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }
    @RequestMapping(value = "getById")
    public Event getBEventById(@RequestParam Integer id) {
        Event event = eventRepository.getBEventById(id);
        return event;
    }
}
