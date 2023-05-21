package com.example.demo.Controller;

import com.example.demo.Models.TicketBooking;
import com.example.demo.Models.UserRegistration;
import com.example.demo.RequestObject.TicketBookingRequest;
import com.example.demo.Service.EventService;
import com.example.demo.Service.TicketBookingService;
import com.example.demo.Service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "ticketBooking" )
public class TicketBookingController {
    @Autowired
    TicketBookingService ticketBookingService;
    @Autowired
    UserRegistrationService userRegistrationService;
    @Autowired
    EventService eventService;

//
@RequestMapping(value = "addTicket", method = RequestMethod.POST)
public String addTicketBookingData(@RequestBody TicketBookingRequest ticketBooking) {
    try {
        ticketBookingService.addTicketBookingData(ticketBooking);
        return "TicketBooking added Successfully";
    } catch (Exception e) {
        return "TicketBooking added Failed";
    }


        }
//    @RequestMapping(value = "getAll",method = RequestMethod.GET)
//    public List<TicketBooking> getAllBookings() {
//        List<TicketBooking> ticketBookingListList = ticketBookingService.getAllBookings();
//        return ticketBookingListList;
//    }
 @RequestMapping(value = "getAll",method = RequestMethod.GET)
 public List<TicketBooking> getAllBookings(){
    List<TicketBooking> bookingList = ticketBookingService.getAllBookings();
    return bookingList;
}
    @RequestMapping(value = "getById")
    public TicketBooking getBookingById(@RequestParam Integer id) {
        TicketBooking ticketBooking = ticketBookingService.getBookingById(id);
        return ticketBooking;
    }

    @GetMapping(value = "deleteById")
    public String deleteBookingById(@RequestParam Integer id) {
        ticketBookingService.deleteBookingById(id);
        return "Record Deleted Successfully :)";

    }
//    @RequestMapping(value = "generateIdByName")
//    public Integer getIdByName(@RequestParam String name) {
//        Integer  ticketBooking = ticketBookingService.getIdByName(name);
//        return ticketBooking;
//    }

    }
