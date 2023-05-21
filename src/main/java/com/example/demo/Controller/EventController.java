package com.example.demo.Controller;

import com.example.demo.Models.Event;
import com.example.demo.Models.TicketBooking;
import com.example.demo.Models.UserRegistration;
import com.example.demo.Repository.EventRepository;
import com.example.demo.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "event" )
public class EventController {
    @Autowired
    EventService eventService;

    @RequestMapping(value = "eventInfo", method = RequestMethod.POST)
    public String addEventData(@RequestParam String name, String dateFrom, String dateTo, Integer numberOfDate, String time,
                               String location, Double price, Integer ticketAvailable,
                               String createdDate, String updatedDate, Boolean isActive) {
        try {
            eventService.addEventData(name, dateFrom, dateTo, numberOfDate, time,location, price, ticketAvailable,createdDate, updatedDate, isActive);
            return "Event added Successfully";
        } catch (Exception e) {
            return "Event added Failed";
        }
    }
    @RequestMapping(value = "getByName")
    public Event getByEventName(@RequestParam String name) {
        Event event = eventService.getByEventName(name);
        return event;
    }
    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public List<Event> getAllEvents(){
        List<Event> eventList = eventService.getAllEvents();
        return eventList;
    }
    @RequestMapping(value = "getById")
    public Event getBEventById(@RequestParam Integer id) {
        Event event = eventService.getBEventById(id);
        return event;
    }

}
